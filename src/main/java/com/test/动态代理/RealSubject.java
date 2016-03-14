package com.test.动态代理;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class RealSubject implements Subject{

    @Override
    public void rent() {

        System.out.println("I want to rent my house");

    }

    @Override
    public void hello(String message) {
        System.out.println("Hello: "+message);
    }
}
