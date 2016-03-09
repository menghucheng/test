package com.test.parser;

import com.pingan.util.DeCompressUtil;
import com.pingan.util.TmplParseUtils;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

/**
 * Created by MENGHUCHENG012 on 2016/2/29.
 * 两种压缩格式的解压方式有区别代码不尽相同
 */
public class ParserTmpl {


    public static File file = new File("D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl\\报文网关-MGW\\报文网关-解析银行响应报文配置模板(MGW-PARSER_TEMPLATE).txt");
//    public static File zipFile = new File("D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\questions.zip");
    public static String zipFiles = "D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl.zip";
    public static String rarFiles = "D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl.rar";


    @Test
    public void test() throws Exception{
//        ReadFile();
        String descDir = "D:\\Users\\menghucheng012\\Desktop\\mine\\tmp\\";
        File files = new File(DeCompressUtil.extract(rarFiles,descDir));
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap = TmplParseUtils.handler(files, dataMap);




        //遍历Map
        for (String key :
             dataMap.keySet()) {
            System.out.println(key+"====="+dataMap.get(key));
        }
    }

}
