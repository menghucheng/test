package com.test.设计模式.观察者模式;

/**
 * Created by MENGHUCHENG012 on 2016/3/30.
 */
public class Observer2 implements IObserver{
    @Override
    public void update() {
        System.out.println("Observer2 has received！");
    }
}
