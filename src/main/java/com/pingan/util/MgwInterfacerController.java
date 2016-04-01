/*
package com.pingan.util;


import com.pinganfu.finmng.common.integration.competence.FmPubCheckClient;
import com.pinganfu.finmng.common.util.FileUtil;
import com.pinganfu.finmng.web.util.DateUtils;
import com.pinganfu.finmng.web.util.DeCompressUtils;
import com.pinganfu.finmngapp.service.facade.bean.FileInfo;
import com.pinganfu.finmngapp.service.facade.bean.FmCheckInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

*/
/**
 * Created by MENGHUCHENG012 on 2016/3/18.
 *//*


@Controller
@RequestMapping("/mgwapp")
public class MgwInterfacerController {

    private final static Logger logger = Logger.getLogger(MgwInterfacerController.class);

    @Autowired
    private FmPubCheckClient fmPubCheckClient;

    @RequestMapping("/toMgwInterfacer")
    public String toMgwInterfacer(Model model){
        return "mgwapp/mgwInterfacer/toMgwInterfacer";
    }


    @RequestMapping("/mgwInterfacerDownload")
    public void downLoadMgwInterfacerFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        OutputStream os = new ByteArrayOutputStream();
        try {
            String fileName = "mgwConfigInterfacerTmpl.zip";
            String tempFilesPath = request.getSession().getServletContext().getRealPath("/WEB-INF/download/");

            FileInfo fileInfo = new FileInfo();
            File downLoadFile = new File(tempFilesPath+"/"+fileName);
            fileInfo.setFileStr(FileUtil.encryptBASE64(FileUtil.getDataHandler(downLoadFile)));
            fileInfo.setFileName(fileName);
            fileInfo.setFileType("zip");

            os = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename="+ java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtil.decryptBASE64(fileInfo.getFileStr()));
            os.flush();
            logger.info("下载配置模板文件成功");
        }  catch(Exception e){
            String errorMsg = "打开文件报错 ："+e.getMessage();
            os.write(errorMsg.getBytes());
            logger.error(" downLoadMgwInterfacerFile :: download 报错", e);
        }finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @RequestMapping("/mgwInterfacerUpload")
    public String upLoadMgwInterfacerFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request){

        String upLoadPath = "/WEB-INF/upload/";
        String extraPath = upLoadPath+"temp/";

        String fileName = file.getOriginalFilename();
        String nowTime =  DateUtils.getCurrentDateTime();
        Boolean errFlag = false;
        try {
            String filePath = request.getSession().getServletContext().getRealPath(upLoadPath);

            File dir = new File(filePath);

            if(!dir.exists()){
                dir.mkdir();
            }

            String newFileName = nowTime + fileName.substring(fileName.lastIndexOf('.'));
            System.out.println(newFileName);

            File uploadFile = new File(new File(filePath),newFileName);
            FileCopyUtils.copy(file.getBytes(),uploadFile);
            uploadFile.createNewFile();
            logger.debug("上传配置模板文件成功");


            DeCompressUtils.extract(filePath+'/'+newFileName,extraPath);

            //审核
//            fmPubCheckClient =
            FmCheckInfo fmCheckInfo = new FmCheckInfo();
//            fmCheckInfo.set



        } catch (Exception e) {
            e.printStackTrace();
            errFlag = true;
        }

        return "mgwapp/mgwInterfacer/upLoadOk";
    }


    private static HashMap<String, String> readFile(File file, HashMap<String, String> dataMap, int filesCount) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(fis,"GBK");
        logger.debug("当前文件："+file.getName());



        //读到的文件数加1
        ++filesCount;
        BufferedReader bfReader = new BufferedReader(isReader);
        //StringBuffer线程安全的  StringBuilder线程非安全的
        StringBuilder sb = new StringBuilder();
        String fileName = file.getName().substring(0,file.getName().indexOf("."));

        String line;

        while (null != (line = bfReader.readLine())){
            sb.append(line);
        }

        String[] contentLines = sb.toString().split("\\|&&\\|");

        //RNumber的位置拿来放记录数
        dataMap.put(fileName+"RNumber",contentLines.length+"");
        for (int i = 1; i < contentLines.length - 1; i++) {
            String[] contents = contentLines[i].split("\\|&\\|");

            if (contents.length == 1 && "".equals(contents[0].trim())){
                logger.error("该表 "+fileName+"无记录");
                dataMap.put(fileName+"RNumber","0");
            }else{
                for (int j = 0; j < contents.length; j++) {
                    dataMap.put(fileName+i+j+"",contents[j]);
                    logger.debug("key::"+fileName+1+j+"        "+"value::"+contents[j]);
                }
            }
        }

        if (fis != null) fis.close();

        if (isReader != null) isReader.close();

        return dataMap;
    }

    //从压缩后的文件夹中读取每个文件的内容
    private static HashMap<String, String> readFiles(File files, HashMap<String, String> dataMap,int filesCount) throws Exception {
        if (files == null){
            logger.debug("找不到文件："+files.getName());
            return null;
        }
        if(!files.isDirectory()){
            dataMap.putAll(readFile(files,dataMap,filesCount));
        }else {
            File[] childFiles = files.listFiles();
            if (childFiles != null){
                for (File file: childFiles) {
                    readFiles(file,dataMap,filesCount);
                }
            }

        }

        return dataMap;
    }

    private static HashMap<String, String> checkHandler(File files, HashMap<String, String> dataMap) throws Exception{
        int filesCount = 0;
        dataMap = readFiles(files, dataMap,filesCount);
        //先判断配置文件的数量对不对
        int count = TemplelateEnum.values().length;
        if(count != filesCount){
            throw new Exception("配置文件的个数不正确!应有："+count+" 实际："+filesCount);
        }

        //解析完数据后删除临时文件
        delFiles(files);
        return dataMap;
    }




    */
/**
     *
     * @param delDir 需要删除的文件夹
     * @return
     * @throws FileNotFoundException
     *//*

    private  static boolean delFiles(File delDir) throws FileNotFoundException {

        boolean flag = false;

        if (!delDir.isDirectory() || delDir==null){
            throw new FileNotFoundException("文件夹不存在或者为空");
        }

        File[] files = delDir.listFiles();

        for (File file: files
                ) {
            if (file.isDirectory()){
                logger.debug("删除临时文件:"+file.getName()+"  结果："+delFiles(file));
            }else{
                */
/**
                 * 如果删除文件失败，分几种情况：文件流未关闭，或被占用(手动删除)，还有文件夹下面还有文件，
                 * 也不能直接删除文件夹下面的文件
                 *//*


                logger.debug("删除文件:"+file.getName()+"  结果："+delFile(file));

            }
        }
        flag = delDir.delete();
        return  flag;
    }

    //删除文件
    private static boolean delFile(File file){
        return file.getAbsoluteFile().delete();
    }


}
*/
