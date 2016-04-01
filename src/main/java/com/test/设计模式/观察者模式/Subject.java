package com.test.设计模式.观察者模式;


/**
 * 发布者（主题对象）
 * Created by MENGHUCHENG012 on 2016/3/30.
 */
public interface Subject {
    /*增加观察者*/
    public void add(IObserver observer);

    /*删除观察者*/
    public void del(IObserver observer);

    /*通知所有的观察者*/
    public void notifyObservers();

    /*自身的操作*/
    public void operation();
}
