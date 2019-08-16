package com.airyny.agency.interceptor;

import java.lang.reflect.Method;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:10:44
 **/
public class MyInterceptor implements Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");

        //false不反射被代理对象原有方法
        //true不反射被代理对象原有方法
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }
}
