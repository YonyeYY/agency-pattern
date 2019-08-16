package com.airyny.agency.jdk;

import com.airyny.agency.facade.Hello;
import com.airyny.agency.impl.HelloImpl;
import com.sun.org.glassfish.gmbal.Description;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Yonye
 * @escription: jdk代理
 * @Date :2019/8/15
 * @Time:9:18
 **/
public class JDKProxyExample implements InvocationHandler {

    //真实对象
    private Object target=null;

    /*
     * @Date 9:20 2019/8/15
     * @Description 建立代理对象和真实的代理关系，并返回代理对象
     * @Param [target 真实对象]
     * @return java.lang.Object 代理对象
     **/
    public Object bind(Object target){
        this.target=target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /*
     * @Date 9:22 2019/8/15
     * @Description 代理方法逻辑
     * @Param [proxy 代理对象, method 当前调度方法, args 当前方法参数]
     * @return java.lang.Object 代理结果返回
     **/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        //相当于调用sayHello
        Object obj=method.invoke(target,args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }

    public static void main(String[] args){
        JDKProxyExample jdk=new JDKProxyExample();
        //绑定关系，因为挂在接口Hello下，所以声明代理对象Hello proxy
        Hello proxy=(Hello)jdk.bind(new HelloImpl());
        //注意，此时Hello对象已经是一个代理对象，他会进入代理的逻辑方法invoke里
        proxy.sayHello();
    }
}












