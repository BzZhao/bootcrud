package com.bootcrud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootcrud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


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

    /**
     * 据userId修改密码
     * @param userId 用户的id
     * @param userPassword 新密码
     * @param modifiedUser 修改人
     * @param modifiedTime  修改时间
     * @return 如果成功返回受影响的行数
     */
    Integer updatePasswordByid(@Param("userId") Integer userId,
                               @Param("userPassword") String userPassword,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") String modifiedTime);

    /**
     * 根据userId查询用户数据
     * @param userId
     * @return User/null
     */
    User findByUserId(Integer userId);


}