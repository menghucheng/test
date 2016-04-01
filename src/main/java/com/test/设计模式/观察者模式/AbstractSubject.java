package com.test.设计模式.观察者模式;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by MENGHUCHENG012 on 2016/3/30.
 */
public abstract class AbstractSubject implements Subject{

    //同步
    private Vector<IObserver> vector = new Vector<IObserver>();

    @Override
    public void add(IObserver observer) {
        vector.add(observer);
    }

    @Override
    public void del(IObserver observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<IObserver> enumo = vector.elements();
        while (enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }

}
