package com.pingan.util;

import com.pingan.Entity.AssableEntity;

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
     * 根据类型分类组装出对象am t 需要组装出的对象
     * @par
     * @param dataMap  组装了所有解析数据的对象,不能改变里面的值
     * @return
     */
    public static AssableEntity getAssableEntity(final HashMap<String, String> dataMap){



        return null;
    }

    public static Object getEntity(int entityId,final HashMap<String, String> dataMap){
        switch (entityId){
            case 1:
                return getAssableEntity(dataMap);
            case 2:
                return null;
        }
        return null;
    }
}
