package com.bootcrud.controller;

import com.bootcrud.service.ex.ServiceException;
import com.bootcrud.service.ex.UsernameDuplicatedException;
import com.bootcrud.service.ex.insertException;
import com.bootcrud.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常类的基类
 */
public class BaseController {
    //操作成功返回给前端的状态码
    //当前项目中产生了异常统一拦截到此方法中
    public static final int OK=200;
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已存在");
        } else if (e instanceof insertException) {
            result.setState(5000);
            result.setMessage("未知异常，注册失败！");
        }
        return result;
    }

}
