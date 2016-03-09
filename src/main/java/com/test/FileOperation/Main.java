package com.test.FileOperation;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by MENGHUCHENG012 on 2016/3/9.
 */
public class Main {
    private static String descDir = "D:\\Users\\menghucheng012\\Desktop\\mine\\tmp\\";

    public static void main(String[] args) {
        try {
            System.out.println(FileUtils.delFiles(new File(descDir)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
