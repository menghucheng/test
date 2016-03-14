package com.pingan.util;

import com.pingan.Entity.AssableEntity;

import java.util.HashMap;

/**
 * Created by MENGHUCHENG012 on 2016/3/10.
 */
public class ComposUtils {

    private static HashMap<String, String> dataMap;

    /**
     * @param dataMap  组装了所有解析数据的对象,不能改变里面的值
     */
    public ComposUtils(final HashMap<String, String> dataMap){
        this.dataMap = dataMap;
    }

    /**
     * 根据类型分类组装出对象am t 需要组装出的对象
     * @par
     * @return
     */
    public static AssableEntity getAssableEntity(){
//        BeanCopier


        return null;
    }

    public static Object getEntity(int entityId){
        switch (entityId){
            case 1:
                return getAssableEntity();
            case 2:
                return null;
        }
        return null;
    }
}
