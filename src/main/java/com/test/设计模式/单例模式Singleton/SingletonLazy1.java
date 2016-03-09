package com.test.设计模式.单例模式Singleton;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 *
 * 懒汉式单例,在第一次被调用的时候才实例化自己，
 * 在多线程环境下可能出现多个实例，改造方法一：在getInstance方法上加上同步
 */
public class SingletonLazy1 {

    //构造私有
    private SingletonLazy1(){}

    private static SingletonLazy1 singletonLazy = null;
    //静态工厂方法
    public static synchronized SingletonLazy1 getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy1();
        }
        return singletonLazy;
    }
}
