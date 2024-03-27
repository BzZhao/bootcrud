package com.bootcrud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootcrud.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper extends BaseMapper<User> {
    /**
     * 插入用户数据
     * @param user 用户的数据
     * @return 返回受影响的行数（增删改）可以通过返回值判断是否执行成功
     */
    int insert(User user);

    /**
     * 根据用户名查找用户数据
     * @param username  用户名
     * @return 如果找到返回这个用户的数据，没有找到返回null
     */
    User findByUsername(String username);
}