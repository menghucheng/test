package com.pingan.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by MENGHUCHENG012 on 2016/3/2.
 */
public class DeCompressUtil {

    private static final Logger logger = Logger.getLogger(DeCompressUtil.class);

    /**
     * 只处理zip格式的压缩包
     * @param compressFilePath 需解压的文件路径
     * @param descDir 解压到的文件夹路径
     * @return 返回解压后的文件路径
     */
    public static String extract(String compressFilePath, String descDir) {

        try {

           File pathFile = new File(descDir);

            if(!pathFile.exists()){
                pathFile.mkdirs();
            }

            if (compressFilePath.toLowerCase().endsWith(".zip")){
                logger.debug("zip文件");
                unZip(compressFilePath,descDir);
            } else{
                throw new IllegalArgumentException("只能解压zip格式压缩包");
            }
            System.out.println("解压缩完成！");
        } catch (Exception e) {
            System.out.println("解压文件出错"+e);
            e.printStackTrace();
        }
        return descDir;
    }

    /**
     * @param compressFilePath 需解压的文件路径
     * @param descDir 解压到的文件夹路径
     * @throws Exception
     */
    private static void unZip(String compressFilePath, String descDir) throws IOException {
        ZipFile zf = new ZipFile(compressFilePath);
        for (Enumeration entries = zf.entries(); entries.hasMoreElements() ;) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEnrtyName = entry.getName().trim();

            File destFile = new File(descDir + zipEnrtyName);

            if(entry.isDirectory()){
                destFile.mkdirs();
            }else{
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(destFile);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len=in.read(buf1)) != -1){
                    out.write(buf1,0,len);
                }
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
            }
        }
    }

}
