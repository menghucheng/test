package com.test.设计模式.委派模式delegate;

/**
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public class B {

    //delegation委派
    A a = new A();

    public void move(){
        a.move();
    }

    public void talk(){
        a.talk();
    }
}
