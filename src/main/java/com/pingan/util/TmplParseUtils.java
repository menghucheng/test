package com.pingan.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by MENGHUCHENG012 on 2016/3/8.
 */
public class TmplParseUtils {

    private static final Logger logger = Logger.getLogger(TmplParseUtils.class);

    private static int filesCount = 0;

    private static HashMap<String, String>  readFile(File file, HashMap<String, String> dataMap) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(fis,"GBK");
        logger.debug("当前文件："+file.getName());
        //读到的文件数加1
        ++filesCount;
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
                logger.error("该表 "+fileName+"无记录");
                dataMap.put(fileName+"RNumber","0");
            }else{
                for (int j = 0; j < contents.length; j++) {
                    dataMap.put(fileName+i+j+"",contents[j]);
                    logger.debug("key::"+fileName+1+j+"        "+"value::"+contents[j]);
                }
            }
        }

        //读完数据后删除解压后的临时文件
        if (file.getAbsoluteFile().delete()){
            logger.debug("删除临时文件："+fileName);
        }else {
            logger.debug("删除失败  =====  临时文件："+fileName+"失败");
        }

        return dataMap;
    }

    //从压缩后的文件夹中读取每个文件的内容
    private static HashMap<String, String> readFiles(File files, HashMap<String, String> dataMap) throws Exception {
        if (files == null){
            System.out.println("Files文件为空");
            return null;
        }
        if(!files.isDirectory()){
            dataMap.putAll(readFile(files,dataMap));
        }else {
            File[] childFiles = files.listFiles();
            if (childFiles != null){
                for (File file: childFiles) {
                    readFiles(file,dataMap);
                }
            }

        }

        return dataMap;
    }

    public static HashMap<String, String> handler(File files, HashMap<String, String> dataMap) throws Exception{
        dataMap = readFiles(files, dataMap);
        //先判断配置文件的数量对不对
        int count = Templelate.values().length;
        if(count != filesCount){
            throw new Exception("配置文件的个数不正确!应有："+count+" 实际："+filesCount);
        }
        return dataMap;
    }

}
