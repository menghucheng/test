package com.test.设计模式.创建型模式.抽象工厂模式;

import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyClass1;
import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyInterface;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class MyFactory1 implements Provider{

    @Override
    public MyInterface produce() {
        return new MyClass1();
    }
}
