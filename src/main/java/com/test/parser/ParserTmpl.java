package com.test.parser;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;
import com.pingan.util.DeCompressUtil;
import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by MENGHUCHENG012 on 2016/2/29.
 * 两种压缩格式的解压方式有区别代码不尽相同
 */
public class ParserTmpl {


    public static File file = new File("D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl\\报文网关-MGW\\报文网关-解析银行响应报文配置模板(MGW-PARSER_TEMPLATE).txt");
//    public static File zipFile = new File("D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\questions.zip");
    public static String zipFiles = "D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl.zip";
    public static String rarFiles = "D:\\Users\\menghucheng012\\Desktop\\mine\\MyFiles\\workplan\\tmpl.rar";



    public HashMap<String, String>  readFile(File file, HashMap<String, String> dataMap) throws Exception {
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

            System.out.println();
        }

//        for (String contenLine : contentLines) {
//            String[] contents = contenLine.split("\\|&\\|");
//            for (String content : contents) {
//                if (content.length() > 20){
//                    content = content.substring(0,20);
//                }
//                System.out.print(content+"        ");
//            }
//            System.out.println();
//        }
        System.out.println();

        return dataMap;
    }

    //从压缩后的文件夹中读取每个文件的内容
    public HashMap<String, String>  readFiles(File files, HashMap<String, String> dataMap) throws Exception {
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

    public void unRar(String compressFilePath, String descDir) throws IOException, RarException {
        Archive a ;
        FileOutputStream fos = null;

        a = new Archive(new File(compressFilePath));
        FileHeader fh = a.nextFileHeader();
        while (fh != null) {
            String fileName = fh.getFileNameString().trim();
            File destFile = new File(descDir + fileName);
            if (!fh.isDirectory()) {
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();
                }
                fos = new FileOutputStream(destFile);
                a.extractFile(fh, fos);
                fos.close();
            }else{
                destFile.mkdirs();
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

    public void unZip(String compressFilePath, String descDir) throws IOException {
        ZipFile zf = new ZipFile(compressFilePath);
        for (Enumeration entries = zf.entries(); entries.hasMoreElements() ;) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEnrtyName = entry.getName().trim();
//            String destFileName;
//            String destDirName;
//
//            //非windows
//            if (File.separator.equals("/")) {
//                destFileName = descDir + zipEnrtyName.replaceAll("\\\\", "/");
//                zipEnrtyName = zipEnrtyName.substring(0,zipEnrtyName.lastIndexOf("/"));
//            } else {// windows系统
//                destFileName = descDir
//                        + compressFileName.replaceAll("/", "\\\\");
//                destDirName = destFileName.substring(0,
//                        destFileName.lastIndexOf("\\"));
//            }
//
//            System.out.println("");

            File destFile = new File(descDir + zipEnrtyName);

            if(entry.isDirectory()){
                destFile.mkdirs();
            }
            else{
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(destFile);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len=in.read(buf1))!=-1){
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
            }
        }
    }

    public String extract(String compressFilePath, String descDir) throws Exception {
        File pathFile = new File(descDir);


        //输出目录不存在时创建
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
        return descDir;
    }





    @Test
    public void test() throws Exception{
//        ReadFile();
        String descDir = "D:\\Users\\menghucheng012\\Desktop\\mine\\tmp\\";
        File files = new File(DeCompressUtil.extract(zipFiles,descDir));
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap = readFiles(files, dataMap);

        //遍历Map
        for (String key :
             dataMap.keySet()) {
            System.out.println(key+"====="+dataMap.get(key));
        }
    }

}
