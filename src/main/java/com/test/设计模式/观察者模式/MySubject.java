package com.test.设计模式.观察者模式;

/**
 * Created by MENGHUCHENG012 on 2016/3/31.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("Update myself!");
        notifyObservers();
    }
}
