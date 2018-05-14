package com.example.demo.controller;

import com.example.demo.model.UpLoadFile;
import com.example.demo.service.UploadFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileOutputStream;

@Controller
public class UploadFileController {
    @Autowired
    private UploadFileServiceImpl uploadFileService;

    private String filePath = "E:/uploadfile/";
    /**
     *  实名认证
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file){
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        try {
            byte[] bytes = file.getBytes();
//            String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
            try {
//                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
                //-------------存储文件--------------
                File targetFile = new File(filePath);
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                String path = filePath+fileName;
                FileOutputStream out = new FileOutputStream(path);
                out.write(bytes);
                out.flush();
                out.close();
                System.out.println("存入E盘成功！");
                //---------------base64---------
                String base64Str = "";
                BASE64Encoder encoder = new BASE64Encoder();
                String jdkEncode = encoder.encode(bytes);
//                System.out.println("JDKEncode-->" + jdkEncode);

                //------------insert into database----------
                UpLoadFile upLoadFile = new UpLoadFile();
                upLoadFile.setFilepath(path);
                upLoadFile.setBase64(jdkEncode);
                upLoadFile.setName("费德勒");
                int id = uploadFileService.insertObj(upLoadFile);
                System.out.println(upLoadFile.getFilepath());
                System.out.println("插入数据库成功！");
                //--------------查询出base64再解码看看是否还能还原为图片---------------
                /*BASE64Decoder decoder = new BASE64Decoder();
//                System.out.println("JDKDecode-->" + new String(decoder.decodeBuffer(jdkEncode)));
                String rbase64FromDataBase = uploadFileService.selectBase64(id);
                FileOutputStream out2 = new FileOutputStream(filePath+"_fromDB" + fileName);
                out2.write(rbase64FromDataBase.getBytes());
                out2.flush();
                out2.close();*/
                return "SUCCESS: id=" + upLoadFile.getId();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "FALSE";
    }

    @RequestMapping("/getFileFromDB/{id}")
    @ResponseBody
    public String setFileFromDB(@PathVariable int id){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            UpLoadFile upLoadFile = uploadFileService.selectBase64(id);
            //图片位置
            String path = upLoadFile.getFilepath();
            path = path.substring(0, path.indexOf(".")) + "_fromDB" + path.substring(path.indexOf("."));
            //图片base64内容
            String rbase64FromDataBase = upLoadFile.getBase64();
            byte[] content = decoder.decodeBuffer(rbase64FromDataBase);
            //创建文件夹
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            //创建文件
            FileOutputStream out2 = null;
            out2 = new FileOutputStream(path);
            out2.write(content);
            out2.flush();
            out2.close();
            System.out.println("将图片从数据库转移至E盘成功");
            return rbase64FromDataBase;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
