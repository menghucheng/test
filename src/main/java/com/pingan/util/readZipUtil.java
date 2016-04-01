package com.pingan.util;

import com.pingan.Entity.AssableEntity;
import com.pingan.Entity.ParserEntity;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by MENGHUCHENG012 on 2016/3/31.
 */
public class readZipUtil {

    private static final Logger logger = Logger.getLogger(readZipUtil.class);

    public static void main(String[] args) {
        HashMap<String, List<? extends Object>> dataMap = null;
        HashMap<String,String> infoMap = new HashMap<String, String>(4);
        try {
            dataMap = readZipFile("D:\\20160331161324.zip",infoMap);
            infoMap.put("confsFilesPath","保存的路径");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, List<? extends Object>> readZipFile(String file,HashMap<String,String> hashMap) throws Exception {

        HashMap<String, List<? extends Object>> dataMap = new HashMap<String, List<? extends Object>>();

        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        String fileName;
        int filesCount = 0;
        StringBuilder confsAllRecordsNum = new StringBuilder();

        while ((ze=zin.getNextEntry()) != null){
            filesCount ++;
            fileName = ze.getName();
            if(!ze.isDirectory()){
                fileName = fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
                System.out.println("file - "+fileName
                        + " : " + ze.getSize() + " bytes");
                BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
                br.close();

                String[] contentLines = sb.toString().split("\\|&&\\|");

                if(fileName.equals("MGW_ASSEMBLE_TEMPLATE")){
                    ArrayList<AssableEntity> assableEntityList = new ArrayList<AssableEntity>();

                    //除去第一行的标题
                    for (int i = 1; i < contentLines.length; i++) {
                        AssableEntity assableEntity = new AssableEntity();
                        String[] contents = contentLines[i].split("\\|&\\|");

                        if (simpleVerfy(contents,fileName,10)) {
                            //进行装配
                            int index = 0;
                            assableEntity.setExchangeTypeId(contents[index++]);
                            assableEntity.setChannelSystemId(contents[index++]);
                            assableEntity.setTemplateType(contents[index++]);
                            assableEntity.setTemplateContent(contents[index++]);
                            assableEntity.setSubTemplate1(contents[index++]);
                            assableEntity.setSubTemplate2(contents[index++]);
                            assableEntity.setHeaderTemplate(contents[index++]);
                            assableEntity.setMessageType(contents[index++]);
                            assableEntity.setCurTransSeq(contents[index++]);
                            assableEntity.setNextTransSeq(contents[index++]);

                            assableEntity.setGmtCreate(new Date());
                            assableEntity.setGmtModified(new Date());

                            assableEntityList.add(assableEntity);
                        }
                    }
                    confsAllRecordsNum.append("文件："+fileName+"("+assableEntityList.size()+");");
                    dataMap.put(fileName,assableEntityList);
                }else if (fileName.equals("MGW_PARSER_TEMPLATE")){
                    ArrayList<ParserEntity> parserEntityList = new ArrayList<ParserEntity>();

                    //除去第一行的标题
                    for (int i = 1; i < contentLines.length; i++) {
                        ParserEntity parserEntity = new ParserEntity();
                        String[] contents = contentLines[i].split("\\|&\\|");

                        //判断是否只有一行标题，无数据的；判断列数是否正确
                        if (simpleVerfy(contents,fileName,7)) {
                            //进行装配
                            int index = 0;
                            parserEntity.setChannelSystemId(contents[index++]);
                            parserEntity.setExchangeTypeId(contents[index++]);
                            parserEntity.setGroovyContent(contents[index++]);
                            parserEntity.setMemo(contents[index++]);
                            parserEntity.setGroovyClassName(contents[index++]);
                            parserEntity.setCurTransSeq(contents[index++]);
                            parserEntity.setNextTransSeq(contents[index++]);

                            parserEntity.setGmtCreate(new Date());
                            parserEntity.setGmtModified(new Date());

                            parserEntityList.add(parserEntity);
                        }
                    }
                    confsAllRecordsNum.append("文件："+fileName+"("+parserEntityList.size()+");");
                    dataMap.put(fileName, parserEntityList);
                }else {
                    confsAllRecordsNum.append("文件："+fileName+"不能解析;");
                    logger.debug("文件名："+fileName+"不能解析");
                }
            }
//            System.out.println("=============");
        }

        hashMap.put("confsFilesNum",filesCount+"");
        hashMap.put("confsAllRecordsNum",confsAllRecordsNum.toString());
        hashMap.put("confsFile",file.substring(file.lastIndexOf(File.separator)+1)); //配置文件名 *.zip
        zin.closeEntry();
        return dataMap;
    }

    private static boolean simpleVerfy(String[] contents,String fileName,int cols) throws IllegalArgumentException{

        //判断是否只有一行标题，无数据的；判断列数是否正确
        if(contents.length != cols) {
            logger.error("数据不正确，请检查文件数据");
            throw new IllegalArgumentException("数据不正确，请检查文件数据");
        }else if (contents.length == 1 && "".equals(contents[1].trim())){
            logger.error("该表 "+fileName+"无记录");
            return false;
        }
        return true;
    }
}
