package com.pingan.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;

/**
 * Created by MENGHUCHENG012 on 2016/3/10.
 */
public class ComposUtils {

    private static HashMap<String, String> dataMap;

    public ComposUtils(HashMap<String, String> dataMap){
        this.dataMap = dataMap;
    }


    /**
     * 根据类型分类组装出对象
     * @param t 需要组装出的对象
     * @param dataMap  组装了所有解析数据的对象,不能改变里面的值
     * @return
     */
    public static T getAssableEntity(T t,final HashMap<String, String> dataMap){



        return null;
    }

    public static Object getEntity(String tmplName){
        return null;
    }
}
