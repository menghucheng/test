package com.pingan.util;

import java.io.*;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by MENGHUCHENG012 on 2016/3/31.
 */
public class readZipUtil {


    public static void main(String[] args) {
        try {
            readZipFile("D:\\20160331161324.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readZipFile(String file) throws IOException {
        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        int filesCount = 0;

        while ((ze=zin.getNextEntry()) != null){
            System.out.println(ze.getName());
            if(!ze.isDirectory()){
                System.out.println("file - "+ze.getName()
                    + " : " + ze.getSize() + " bytes");
            }else{
                filesCount ++;
            }
            long size = ze.getSize();
            if(size > 0){
                BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }

                br.close();

            }
            System.out.println();
        }

        System.out.println("文件数："+filesCount);
        zin.closeEntry();
    }

    public static void simpleReadZipFile(String file) throws IOException {
        HashMap<String,String> hashMap = new HashMap<String, String>();

        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        int filesCount = 0;

        while ((ze=zin.getNextEntry()) != null){
            System.out.println(ze.getName());
            if(!ze.isDirectory()){
                System.out.println("file - "+ze.getName()
                        + " : " + ze.getSize() + " bytes");
            }else{
                filesCount ++;
            }
            long size = ze.getSize();
            if(size > 0){
                BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }

                br.close();

            }
            System.out.println();
        }

        hashMap.put("confsFilesNum",filesCount+"");
        hashMap.put("confsAllRecordsNum",filesCount+"");
        hashMap.put("confsFile",file.substring(file.lastIndexOf("/"))); //配置文件名 *.zip
        hashMap.put("confsFilesPath",filesCount+"");
        System.out.println("文件数："+filesCount);
        zin.closeEntry();
    }
}
