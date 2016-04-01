package com.test.FileOperation;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by MENGHUCHENG012 on 2016/4/1.
 */
public class transFiles {

    private static final Logger logger = Logger.getLogger(transFiles.class);

    public static void main(String[] args) {
        String fileName = "20160331161324";
        String uploadPath = "D:\\tmp"+ File.separator ;

        byte[] b = getConfigsFile(fileName);

        System.out.println(uploadConfigsFile(b,fileName+"copy"));;


    }

    public static String uploadConfigsFile(byte[] fileByte, String fileName){
        try {
//            String filePath = PropertyUtils.getProperty("mgw_check_file_path", PropertyUtils.APPLICATION);
            String uploadPath = "D:\\tmp"+ File.separator ;
            File dir = new File(uploadPath);
            if(!dir.exists()){
                if(!dir.mkdirs()){
                    return null;
                }
            }
            File uploadFile = new File(dir,fileName+".zip");
            FileCopyUtils.copy(fileByte,uploadFile);
            return dir+File.separator+fileName+".zip";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] getConfigsFile(String fileName){
        ByteArrayOutputStream bos = null;
        FileInputStream fileInputStream = null;
        try {
            // /nfsc/fncp_frcs_id337618_vol_stg1/mgw/mgwconfigs/
//            String filePath = PropertyUtils.getProperty("mgw_check_file_path", PropertyUtils.APPLICATION);
            String downloadPath = "D:"+ File.separator ;
            fileInputStream = new FileInputStream(new File(downloadPath+fileName+".zip"));
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n ;
            while ((n = fileInputStream.read(b)) !=-1){
                bos.write(b,0,n);
            }
            bos.flush();
            logger.error("内容 :"+bos.toByteArray().length+new String(bos.toByteArray()));
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
