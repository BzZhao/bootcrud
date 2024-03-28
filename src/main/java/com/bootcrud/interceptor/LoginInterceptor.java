package com.bootcrud.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    //preHandle 请求方法前置拦截，该方法会在Controller处理之前进行调用，Spring中可以有多个Interceptor，
    //这些拦截器会按照设定的Order顺序调用，当有一个拦截器在preHandle中返回false的时候，请求就会终止。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("userId");
        if(obj == null){    //用户没有登陆过系统，重定向到login页面
            response.sendRedirect("/web/login.html");
            //结束后续调用
            return false;
        }
        //请求放行
        return true;
    }

    /**
     * 在Controller方法执行之后，视图渲染之前被调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    /**
     *  在整个请求结束之后，执行该方法
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
