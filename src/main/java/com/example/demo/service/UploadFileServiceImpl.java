package com.example.demo.service;

import com.example.demo.mapper.UploadFileMapper;
import com.example.demo.model.UpLoadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl {
    @Autowired
    private UploadFileMapper uploadFileMapper;

    public int insertObj(UpLoadFile upLoadFile){
        return uploadFileMapper.insertObj(upLoadFile);
    }

    public UpLoadFile selectBase64(int id){
        return uploadFileMapper.selectBase64ById(id);
    }
}
