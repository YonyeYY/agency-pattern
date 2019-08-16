package com.airyny.pattern.responsibility.Interceptor;

import java.lang.reflect.Method;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:11:42
 **/
public class Interceptor1 implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】的before 方法");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】around 方法");

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】after 方法");

    }
}
