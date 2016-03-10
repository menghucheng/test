package com.pingan.Entity;

/**
 * Created by MENGHUCHENG012 on 2016/3/10.
 */

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

public class AbstractModel implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -2993007905380519870L;
//复制拷贝对象相同类型、名字的值 spring框架的类
//    public <T> T convert(Class<T> targetClass) throws InstantiationException,
//            IllegalAccessException {
//        BeanCopier copier = BeanCopier.create(this.getClass(), targetClass, false);
//        T instance = targetClass.newInstance();
//        copier.copy(this, instance, null);
//        return instance;
//    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}


