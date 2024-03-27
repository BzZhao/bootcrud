package com.bootcrud.service;

import com.bootcrud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    User login(User user);
}
