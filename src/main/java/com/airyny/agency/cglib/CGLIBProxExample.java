package com.airyny.agency.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.sql.Ref;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:10:11
 **/
public class CGLIBProxExample implements MethodInterceptor {
    /*
     * @Description 生成CGLIB 代理对象
     * @param cls  Class类
     * @return java.lang.Object  Class类的CGLIB 代理对象
     **/
    public Object getProxy(Class cls){
        //CGLIB enhancer 增强类对象
        Enhancer enhancer=new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor接口
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /*
     * @Description 代理逻辑方法
     * @param o 代理对象
    * @param method 方法
    * @param objects 方法参数
    * @param methodProxy 方法代理
     * @return java.lang.Object  代理逻辑返回
     **/
    public Object intercept(Object o, Method method,
                            Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        //CGLIB 反射调用真实对象方法
        Object result=methodProxy.invokeSuper(o,objects);
        System.err.println("调用真实对象后");
        return result;
    }

    public static void main(String[] args){
        CGLIBProxExample cglibProxExample=new CGLIBProxExample();
        ReflectServiceImpl obj=
                (ReflectServiceImpl) cglibProxExample.getProxy(ReflectServiceImpl.class);

        obj.sayHello("Jun");
    }
}




















