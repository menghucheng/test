package com.test.FileOperation;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 */
public class FileUtils {

    private static final Logger logger = Logger.getLogger(FileUtils.class);

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
                logger.debug("删除文件:"+file.getName()+"  结果："+delFiles(file));
            }else{
                /**
                 * 如果删除文件失败，分几种情况：文件流未关闭，或被占用(手动删除)，还有文件夹下面还有文件，
                 * 也不能直接删除文件夹下面的文件
                 */

                logger.debug("删除文件:"+file.getName()+"  结果："+delFile(file));

            }
        }
        flag = delDir.delete();
        return  flag;
    }

    //删除文件
    public  static boolean delFile(File file){
        return file.getAbsoluteFile().delete();
    }
}
