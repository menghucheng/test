package com.test.设计模式.单例模式Singleton;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 *
 * 懒汉式单例,在第一次被调用的时候才实例化自己，
 * 在多线程环境下可能出现多个实例
 */
public class SingletonLazy {

    //构造私有
    private SingletonLazy(){}

    private static SingletonLazy singletonLazy = null;
    //静态工厂方法
    public static SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
