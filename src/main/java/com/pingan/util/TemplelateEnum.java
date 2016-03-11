package com.pingan.util;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 */
public enum TemplelateEnum {

    /**
     * 报文网关
     */

    //组装请求银行报文配置模板
    MGW_ASSEMBLE_TEMPLATE(1),

    //解析银行响应报文配置模板
    MGW_PARSER_TEMPLATE(2),

    //通讯信息配置模板
    MGW_COMMUNICATION(3),

    //通讯交易类型配置模板
    MGW_TRANSACTION_TYPE(4),


    //证件类型映射配置模板
    MGW_CERTIFICATE_TYPE(5),

    //渠道字典参数配置模板
    MGW_DICT_MAP(6);


    private int id;



    private TemplelateEnum(int id){
        this.id = id;
    }


    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
