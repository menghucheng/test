package com.test.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class Client {
    public static void main(String[] args) {
        //需要代理的真实对象
        Subject realSubject = new RealSubject();

        //传入需要代理的对象
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象
         *
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所对应的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         *
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),handler);

        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");

    }

}
