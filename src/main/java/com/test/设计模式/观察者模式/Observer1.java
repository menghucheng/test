package com.test.设计模式.观察者模式;

/**
 * Created by MENGHUCHENG012 on 2016/3/30.
 */
public class Observer1 implements IObserver{

    @Override
    public void update() {
        System.out.println("Observer1 has received!");
    }
}
