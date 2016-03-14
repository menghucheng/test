package com.test.设计模式.创建型模式.抽象工厂模式;

import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyInterface;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class Main {
    public static void main(String[] args) {
        Provider provider = new MyFactory1();
        MyInterface myInterface = provider.produce();

        myInterface.print();
    }
}
