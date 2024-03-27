package com.bootcrud.controller;

import com.bootcrud.entity.User;
import com.bootcrud.service.UserService;
import com.bootcrud.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.bootcrud.mapper")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("/user/reg")
    public JsonResult<Void> reg(User user){

        userService.reg(user);
        return new JsonResult<>(OK);
    };

    @RequestMapping("/login")
    public JsonResult<User> login(User user, HttpSession session){

        User data = userService.login(user);
        session.setAttribute("userId",data.getUserId());
        session.setAttribute("userName",data.getUserName());
        return new JsonResult<>(OK,data);

    }

/*    @RequestMapping("/user/reg")
    public JsonResult<Void> reg(User user){
        //创建响应结果对象
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        }catch (insertException e){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        }
        return result;
    };*/

}
