package com.pingan.util;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 */
public enum TemplelateEnum {

    /**
     * 报文网关
     */

    //证件类型映射配置模板
    MGW_CERTIFICATE_TYPE("MGW_CERTIFICATE_TYPE"),

    //渠道字典参数配置模板
    MGW_DICT_MAP("MGW_DICT_MAP"),

    //通讯交易类型配置模板
    MGW_TRANSACTION_TYPE("MGW_TRANSACTION_TYPE"),

    //组装请求银行报文配置模板
    MGW_ASSEMBLE_TEMPLATE("MGW_ASSEMBLE_TEMPLATE"),

    //解析银行响应报文配置模板
    MGW_PARSER_TEMPLATE("MGW_PARSER_TEMPLATE"),

    //通讯交易类型配置模板
    MGW_COMMUNICATION("MGW_COMMUNICATION");


    private String name;



    private TemplelateEnum(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
