package com.bootcrud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 盐值
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 0:超级管理员 1:管理员 2:普通用户
     */
    @TableField(value = "user_role")
    private Integer userRole;

    /**
     * 状态：1正常,0失效
     */
    @TableField(value = "user_state")
    private Integer userState;

    /**
     * 日志-创建人
     */
    @TableField(value = "created_user")
    private String createdUser;

    /**
     * 日志-创建时间
     */
    @TableField(value = "crated_time")
    private Date cratedTime;

    /**
     * 日志-最后修改执行人
     */
    @TableField(value = "modified_user")
    private String modifiedUser;

    /**
     * 日志-最后修改时间
     */
    @TableField(value = "modified_time")
    private Date modifiedTime;
}