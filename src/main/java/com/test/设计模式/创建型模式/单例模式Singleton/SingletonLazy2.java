package com.test.设计模式.创建型模式.单例模式Singleton;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 *
 * 懒汉式单例,在第一次被调用的时候才实例化自己，
 * 在多线程环境下可能出现多个实例 改造方法2：双重检查锁定
 */
public class SingletonLazy2 {

    //构造私有
    private SingletonLazy2(){}

    private static SingletonLazy2 singletonLazy = null;
    //静态工厂方法
    public static SingletonLazy2 getInstance(){
        if (singletonLazy == null){
            //可能会有多个线程同时判断到null的情况
            synchronized (SingletonLazy2.class){
                singletonLazy = new SingletonLazy2();
            }
        }
        return singletonLazy;
    }
}
