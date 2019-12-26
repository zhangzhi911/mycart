package com.zhangzhi.inteceptors;


import com.github.pagehelper.PageHelper;
import com.zhangzhi.annotation.Pagable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class PageInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {

            return true;
        }



        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Pagable pagable = method.getAnnotation(Pagable.class);
        if (pagable == null) {
            return true;
        }

        Integer pageSize = 10;
        Integer pageNum = 1;
        try {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (Exception e) {
        }
        try {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        } catch (Exception e) {
        }
        PageHelper.startPage(pageNum, pageSize);
        return true;
    }
}


