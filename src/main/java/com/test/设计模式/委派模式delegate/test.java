package com.test.设计模式.委派模式delegate;

import org.junit.Test;

/**
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public class test {

    @Test
    public void m_test(){
        B b = new B();

        /**
         * 通过B对象执行A对象的方法，将A对象更好的隐藏起来
         */
        b.move();
        b.talk();
    }
}
