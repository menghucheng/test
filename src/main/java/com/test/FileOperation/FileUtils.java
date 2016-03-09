package com.test.FileOperation;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 */
public class FileUtils {

    /**
     *
     * @param delDir 需要删除的文件夹
     * @return
     * @throws FileNotFoundException
     */
    public static boolean delFiles(File delDir) throws FileNotFoundException {
        boolean flag = false;

        if (!delDir.isDirectory() || delDir==null){
            throw new FileNotFoundException("文件夹不存在或者为空");
        }

        File[] files = delDir.listFiles();

        for (File file: files
             ) {
            if (file.isDirectory()){
                delFiles(file);
            }else{
                file.delete();
            }
        }
        flag = delDir.delete();
        return  flag;
    }

    //删除文件
    public  static boolean delFile(){
        return false;
    }
}
