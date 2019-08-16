package com.airyny.agency.interceptor;

import java.lang.reflect.Method;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:10:39
 **/
public interface Interceptor {

    /*
     * @Description 返回true，反射真实对象的方法，
     * 返回false，则调用around方法
     * @param proxy 代理对象
    * @param target 真实对象
    * @param method 方法
    * @param args 运行方法参数
     * @return boolean
     **/
    boolean before(Object proxy, Object target, Method method,Object[] args);

    void around(Object proxy, Object target, Method method,Object[] args);

    void after(Object proxy, Object target, Method method,Object[] args);
}
