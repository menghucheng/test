package com.test.设计模式.创建型模式.静态工厂模式方法StaticFactory;

import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyClass1;
import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyClass2;
import com.test.设计模式.创建型模式.工厂方法模式NormalFactory.MyInterface;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class MyFactory {
    public static MyInterface produce1(){
        return new MyClass1();
    }

    public static MyInterface produce2(){
        return new MyClass2();
    }
}
