package com.pingan.util;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by MENGHUCHENG012 on 2016/3/2.
 */
public class DeCompressUtil {

    /**
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

            if (compressFilePath.toLowerCase().endsWith(".rar")){
                System.out.println("rar文件");
                unRar(compressFilePath,descDir);
            }else{
                System.out.println("zip文件");
                unZip(compressFilePath,descDir);
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

    /**
     * @param compressFilePath 需解压的文件路径
     * @param descDir 解压到的文件夹路径
     * @throws Exception
     */
    private static void unRar(String compressFilePath, String descDir) throws IOException, RarException {
        Archive a = null;
        FileOutputStream fos = null;

        a = new Archive(new File(compressFilePath));
        FileHeader fh = a.nextFileHeader();
        while (fh != null) {
            String fileName = fh.getFileNameString().trim();
            File destFile = new File(descDir + fileName);

            if (!fh.isDirectory()) {
                File parentDir = destFile.getParentFile();

                if (!parentDir.exists()){
                    parentDir.mkdirs();
                }
                fos = new FileOutputStream(destFile);
                a.extractFile(fh, fos);
                fos.close();
            }
            fh = a.nextFileHeader();
        }

        if(a != null){
            a.close();
        }
        if(fos != null){
            fos.close();
        }
    }
}
