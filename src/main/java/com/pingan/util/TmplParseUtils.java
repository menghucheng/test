package com.pingan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public class TmplParseUtils {


    private static HashMap<String, String>  readFile(File file, HashMap<String, String> dataMap) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(fis,"GBK");
        System.out.println("当前文件："+file.getName());
        BufferedReader bfReader = new BufferedReader(isReader);
        //StringBuffer线程安全的  StringBuilder线程非安全的
        StringBuilder sb = new StringBuilder();
        String fileName = file.getName().substring(0,file.getName().indexOf("."));

        String line;

        String titles = bfReader.readLine();
        String[] title = titles.split("\\|&\\|");

        for (String t : title) {
            System.out.print(t+"   ");
        }
        System.out.println();

        while (null != (line = bfReader.readLine())){
            sb.append(line);
        }

        String[] contentLines = sb.toString().split("\\|&&\\|");

        //RNumber的位置拿来放记录数
        dataMap.put(fileName+"RNumber",contentLines.length+"");
        for (int i = 0; i < contentLines.length; i++) {
            String[] contents = contentLines[i].split("\\|&\\|");

            if (contents.length == 1 && "".equals(contents[0].trim())){
                System.out.println("该表 "+fileName+"无记录");
                dataMap.put(fileName+"RNumber","0");
            }else{
                for (int j = 0; j < contents.length; j++) {
                    dataMap.put(fileName+i+j+"",contents[j]);
                    System.out.print("key::"+fileName+1+j+"        "+"value::"+contents[j]);
                    System.out.println();
                }
            }
        }
        return dataMap;
    }

    //从压缩后的文件夹中读取每个文件的内容
    public static HashMap<String, String> readFiles(File files, HashMap<String, String> dataMap) throws Exception {
        if (files == null){
            System.out.println("Files文件为空");
            return null;
        }
        if(!files.isDirectory()){
            dataMap.putAll(readFile(files,dataMap));
        }else {
            File[] childFiles = files.listFiles();
            for (File file: childFiles) {
                readFiles(file,dataMap);
            }
        }
        return dataMap;
    }

}
