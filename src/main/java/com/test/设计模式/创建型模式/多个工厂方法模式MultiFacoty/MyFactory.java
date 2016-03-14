package com.test.设计模式.创建型模式.多个工厂方法模式MultiFacoty;

import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyClass1;
import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyClass2;
import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyInterface;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 * 多工厂模式方法，测试省略
 */
public class MyFactory {

    public MyInterface produce1(){
        return new MyClass1();
    }

    public MyInterface produce2(){
        return new MyClass2();
    }
}
