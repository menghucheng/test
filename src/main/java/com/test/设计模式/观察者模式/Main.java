package com.test.设计模式.观察者模式;

/**
 * Created by MENGHUCHENG012 on 2016/3/31.
 */
public class Main {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
