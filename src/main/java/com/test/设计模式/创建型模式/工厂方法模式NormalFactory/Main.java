package com.test.设计模式.创建型模式.工厂方法模式NormalFactory;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 *
 * 普通工厂模式
 *  普通工厂模式就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 */
public class Main {

    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        MyInterface myInterface = myFactory.produce(1);
        if (myInterface != null){
            myInterface.print();
        }

        myInterface = myFactory.produce(2);
        if (myInterface != null){
            myInterface.print();
        }

        myInterface = myFactory.produce(3);
        if (myInterface != null){
            myInterface.print();
        }
    }
}
