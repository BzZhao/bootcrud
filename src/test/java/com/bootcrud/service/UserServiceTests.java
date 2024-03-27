package com.bootcrud.service;


import com.bootcrud.entity.User;
import com.bootcrud.mapper.UserMapper;
import com.bootcrud.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//RunWith表示启动这个单环测试类（最外层的tests可以不添加，否则不可运行），需要传递一个参数SpringRunner.class的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;
    /**
     * 单元测试方法：可以独立运行，不用启动整个项目，可以做单元测试，提示了代码的测试效率
     * 1.必须被@test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.访问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUserName("hanli");
            user.setUserPassword("12345");
            userService.reg(user);
            System.out.println("插入成功"+user.getUserName());
        } catch (ServiceException e) {
            //拿到异常类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }
}
