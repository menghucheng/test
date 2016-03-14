package com.test.设计模式.创建型模式.单例模式Singleton;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 * 饿汉式单例  在类初始化的时候就已经自行实例化，会一直存在于内存中
 * 本身就是线程安全的
 */
public class SingletonHunger {

    private SingletonHunger(){}

    private static final SingletonHunger instance = new SingletonHunger();

    //静态工厂方法
    public static SingletonHunger getInstance(){
        return instance;
    }
}
