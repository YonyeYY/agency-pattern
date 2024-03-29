package com.airyny.pattern.responsibility.Interceptor;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/15
 * @Time:14:06
 **/
public class ResponsibilityProxy implements InvocationHandler {

    //真实对象
    private Object target;

    //拦截器全限定名
    private String interceptorClass = null;

    public ResponsibilityProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /*
     * @Date 11:00 2019/8/15
     * @Description 绑定委托对象并返回一个【代理占位】
     * @param target 真实对象
     * @param interceptorClass
     * @return java.lang.Object
     * @exception
     **/
    public static Object bind(Object target, String interceptorClass) {
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ResponsibilityProxy(target, interceptorClass));
    }

    /*
     * @Description 通过代理对象调用方法，首先进入这个方法
     * @param proxy 代理对象
     * @param method 方法，被调用方法
     * @param args 方法的参数
     * @return java.lang.Object
     **/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            //没有设置拦截器则直接反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            //反射原有对象方法
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        //调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }


    public static void main(String[] args){

        Holiday proxy1 = (Holiday) ResponsibilityProxy.bind(
                new HolidayImpl(),"com.airyny.pattern.responsibility.Interceptor.Interceptor1");

        Holiday proxy2 = (Holiday) ResponsibilityProxy.bind(
                proxy1,"com.airyny.pattern.responsibility.Interceptor.Interceptor2");

        Holiday proxy3 = (Holiday) ResponsibilityProxy.bind(
                proxy2,"com.airyny.pattern.responsibility.Interceptor.Interceptor3");

        proxy3.getHoliday();
    }
}


