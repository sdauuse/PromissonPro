package com.miao.interceptor;

import com.miao.utils.RequestUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author miaoyin
 * @date 2021/1/26 - 19:59
 * @commet:
 */
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("来到了拦截器...");
//        通过拦截器存放HttpServletRequest
        RequestUtil.setRequest(request);
        return true;
    }
}
