package com.test.testString;

import org.junit.Test;

/**
 * Created by MENGHUCHENG012 on 2016/3/7.
 */
public class testSplit {

    @Test
    public void test(){
        String str = "aa|@|";
        String str1 = "aa|@|qq";

        System.out.println(str1.split("\\|@@\\|").length);
    }
}
