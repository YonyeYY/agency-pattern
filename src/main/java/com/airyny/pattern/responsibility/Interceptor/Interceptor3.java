package com.airyny.pattern.responsibility.Interceptor;

import java.lang.reflect.Method;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:11:43
 **/
public class Interceptor3 implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】的before 方法");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】around 方法");

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】after 方法");

    }
}