package com.bootcrud.config;

import com.bootcrud.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册，哪些请求放行或拦截
 */
@Configuration //加载当前的拦截器并进行注册
public class LoginInterceptorConfig implements WebMvcConfigurer {


    //配置白名单

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 配置拦截器 */
        HandlerInterceptor interceptor = new LoginInterceptor();
        //添加白名单
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/user/reg");
        patterns.add("/user/login");



        registry.addInterceptor(interceptor)
                .addPathPatterns("/**") //表示要拦截的url是什么  /**代表所有的请求都被拦截
                .excludePathPatterns(patterns);  //白名单设置patterns

    }
}
