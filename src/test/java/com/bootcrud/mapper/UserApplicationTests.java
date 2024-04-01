package com.bootcrud.mapper;


import com.baomidou.mybatisplus.core.toolkit.MybatisBatchUtils;
import com.bootcrud.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//RunWith表示启动这个单环测试类（最外层的tests可以不添加，否则不可运行），需要传递一个参数SpringRunner.class的实例类型
@RunWith(SpringRunner.class)
public class UserApplicationTests {

    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法：可以独立运行，不用启动整个项目，可以做单元测试，提示了代码的测试效率
     * 1.必须被@test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUserName("lindong");
        user.setUserPassword("123456");

        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void findByUserName(){
        User user = userMapper.findByUsername("lindong");
        System.out.println(user.toString());
    }

    @Test
    public void selectpage(){

    }


}
