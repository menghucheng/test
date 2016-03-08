package com.test.testString.testMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MENGHUCHENG012 on 2016/3/7.
 */
public class testHashMap {

    @Test
    public void test(){
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("12","AB");
        hashMap.put("12","AB");

        System.out.println(hashMap.size());
        for (Map.Entry entry: hashMap.entrySet()) {
            System.out.println(entry.getKey()+"::"+entry.getValue());;
        }
    }
}
