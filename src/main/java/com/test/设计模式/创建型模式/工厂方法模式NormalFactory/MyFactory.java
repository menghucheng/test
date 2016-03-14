package com.test.设计模式.创建型模式.工厂方法模式NormalFactory;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class MyFactory {

    public MyInterface produce(int type){
        if(1 == type){
            return new MyClass1();
        }else if(2 == type){
            return new MyClass2();
        }else {
            System.out.println("找不到该类型");
            return null;
        }
    }
}
