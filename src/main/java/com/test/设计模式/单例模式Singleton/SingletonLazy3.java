package com.test.设计模式.单例模式Singleton;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 *
 * 懒汉式单例,在第一次被调用的时候才实例化自己，
 * 在多线程环境下可能出现多个实例 改造方法三：静态内部类（由于内部静态类只会被加载一次，故该实现方式时线程安全的！）
 *
 * 这种方法比前两种都好些
 */
public class SingletonLazy3 {

    //构造私有
    private SingletonLazy3(){}

    private static class Singleton{
        private static final SingletonLazy3 INSTANCE = new SingletonLazy3();
    }


    //静态工厂方法
    public static SingletonLazy3 getInstance(){
        return Singleton.INSTANCE;
    }
}
