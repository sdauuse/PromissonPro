package com.miao.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author miaoyin
 * @date 2021/1/26 - 20:03
 * @commet:
 */
public class RequestUtil {

    //能够全局的存放一些内容
    public static ThreadLocal<HttpServletRequest> local = new ThreadLocal<>();

    // 全局的取出内容
    public static HttpServletRequest getRequest() {
        return local.get();
    }

    //全局的存放内容
    public static  void setRequest(HttpServletRequest request){
        local.set(request);
    }
}
