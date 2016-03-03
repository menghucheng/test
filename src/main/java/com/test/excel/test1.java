package com.test.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by MENGHUCHENG012 on 2016/2/16.
 * HSSFWorkbook表示一个完整的excel表格，HSSFsheet表示excel中的一个工作簿
 * HSSFRow表示工作簿中的一行，HSSFCell表示一个单元格
 */
public class test1 {
    public static final String fileName = "D:\\Users\\menghucheng012\\Desktop\\test.xls";
    //简单的写入demo
    public static void write(){
      try{
          HSSFWorkbook workbook = new HSSFWorkbook();
          HSSFSheet sheet = workbook.createSheet();
          HSSFRow row = sheet.createRow(0);
          HSSFCell cell = row.createCell(1);
          cell.setCellValue("Hello");
          File file = new File(fileName);
          FileOutputStream fos = new FileOutputStream(file);
          workbook.write(fos);
          fos.flush();
          fos.close();
      }catch(Exception e){
          e.printStackTrace();
      }
        System.out.println("wirte over!");
    }

    public static void read(){
        try{
            FileInputStream fis = new FileInputStream(fileName);
            POIFSFileSystem poifs = new POIFSFileSystem(fis);
            HSSFWorkbook workbook = new HSSFWorkbook(poifs);
            HSSFSheet sheet = workbook.getSheetAt(0);//获取第一个工作簿
            HSSFRow row = null;
            for (int i = 0; i<= sheet.getLastRowNum() ; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    System.out.println(row.getCell(j)+"==");
                }
                System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("read over");
    }

    public static void main(String[] args) {
        write();
        read();
    }
}
