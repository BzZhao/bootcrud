package com.bootcrud.service.impl;

import ch.qos.logback.core.joran.action.NewRuleAction;
import com.bootcrud.service.ex.PasswordNotMatchException;
import com.bootcrud.service.ex.UserNotFoundException;
import com.bootcrud.service.ex.UsernameDuplicatedException;
import com.bootcrud.service.ex.insertException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootcrud.mapper.UserMapper;
import com.bootcrud.entity.User;
import com.bootcrud.service.UserService;
import org.springframework.util.DigestUtils;

@Service    //@Service注解 将当前类的对象交给spring来管理，自动创建对象和对象的管理
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public void reg(User user) {
        //调用user.getUserName()方法得到username
        String username = user.getUserName();
        //调用findByUsername（username）判断用户是否注册过
        User result = userMapper.findByUsername(username);
        //判断结果是不是null，不为null抛出异常
        if(result != null){
            //抛出异常
            throw new UsernameDuplicatedException("用户名已存在");
        }

        //密码加密
        //盐值+密码+盐值  --盐值随机的字符串 --连续加密三次
        String oldpassword = user.getUserPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //将盐值和密码共同加密 --忽略原有密码强度提升安全性
        String md5Password = getMd5(oldpassword,salt);
        //加加密后的密码放在user数据中
        user.setUserPassword(md5Password);
        //将盐值保存到user数据中
        user.setSalt(salt);
        //补全数据 user_state 4个日志字段信息
        user.setUserState(0);
        user.setCreatedUser(user.getUserName());
        Date date = new Date();
        user.setCratedTime(date);
        user.setModifiedUser(user.getUserName());
        user.setModifiedTime(date);
        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new insertException("注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(User user) {
        //根据用户名查询用户的数据是否存在，如果不存在抛出异常
        String username = user.getUserName();
        User result = userMapper.findByUsername(username);
        if(result == null){
            throw new UserNotFoundException("用户数据不存在！");
        }
        //检测用户的密码是否匹配
        //获取数据库中加密之后的密码
        String oldMd5Password = result.getUserPassword();
        //将用户的密码按照相同的算法加密
        String newMd5Password = getMd5(user.getUserPassword(),user.getSalt());
        if(!newMd5Password.equals(oldMd5Password)){
            throw new PasswordNotMatchException("密码错误！");
        }

        //判断用户状态 1：被删除
        if(result.getUserState() == 1){
            throw new UserNotFoundException("用户不存在！");
        }
        user = new User();
        user.setUserId(result.getUserId());
        user.setUserName(result.getUserName());

        return user;
    }

    /**
     * md5算法加密
     */
    public String getMd5(String password,String salt){
        //三次加密
        for(int i = 0 ; i<3 ; i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        //返回加密后的密码
        return password;
    }
}
