package com.test.设计模式.适配器模式Adaptor.对象和类适配器;

import com.test.设计模式.适配器模式Adaptor.Adaptee;
import com.test.设计模式.适配器模式Adaptor.Target;

/**
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public class ObjectAdaptor implements Target{
    Adaptee adaptee = new Adaptee();

    @Override
    public void sampleOperation1() {
        adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
        //方法的实现 
    }
}
