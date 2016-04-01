package com.test.String;

import java.io.File;

/**
 * Created by MENGHUCHENG012 on 2016/3/23.
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "D:\\mhc\\code\\finmng\\finmng_req13773_2016.04.07release\\web\\finmng-web\\target\\fncp-fm-web\\WEB-INF\\upload/20160323195005.zip";
//
//        System.out.println(str.substring(str.lastIndexOf("/")+1,str.lastIndexOf(".")));
//        "{"confsFile":"<button><a href=\"mgwInterfacerDownloadByName?fileName=20160323212815.zip\">下载<\/a><\/button>","confsAllRecordsNum":"3","confsFilesPath":"D:\\mhc\\code\\finmng\\finmng_req13773_2016.04.07release\\web\\finmng-web\\target\\fncp-fm-web\\WEB-INF\\upload/20160323212815.zip","confsFilesNum":"2"}";
//        String jsonStr = "{\"confsFile\":\"<button><a href=\\\"mgwInterfacerDownloadByName?fileName=20160323211752.zip\\\">下载<\\/a><\\/button>\",\"confsAllRecordsNum\":\"3\",\"confsFilesPath\":\"D:\\\\mhc\\\\code\\\\finmng\\\\finmng_req13773_2016.04.07release\\\\web\\\\finmng-web\\\\target\\\\fncp-fm-web\\\\WEB-INF\\\\upload/20160323211752.zip\",\"confsFilesNum\":\"2\"}";
//
//        Map<String, String> map= (Map<String,String>)JSON.parse(jsonStr);
//
//        for (String key : map.keySet()){
//            System.out.println(map.get(key));
//        }

        String fileName = "20160324094124.zip";

//        System.out.println(str.substring(0,str.lastIndexOf("/")));
        System.out.println(fileName.substring(0,fileName.lastIndexOf(".")));

        System.out.println(File.separator);
        System.out.println("tmpl/MGW/MGW_ASSEMBLE_TEMPLATE.txt".substring("tmpl/MGW/MGW_ASSEMBLE_TEMPLATE.txt".lastIndexOf(File.separator)+1));

    }
}
