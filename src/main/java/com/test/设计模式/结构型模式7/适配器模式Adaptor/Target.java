package com.test.设计模式.结构型模式7.适配器模式Adaptor;

/**
 * 目标角色(Target):这就是所期待得到的接口。
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public interface Target {
    /**
     * 这是原来接口中有的方法
     */
    public void sampleOperation1();

    /**
     * 这事原来接口中没有的方法
     */
    public void sampleOperation2();
}
