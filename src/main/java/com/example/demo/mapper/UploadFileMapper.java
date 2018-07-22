package com.example.demo.mapper;

import com.example.demo.model.UpLoadFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadFileMapper {
    int insertObj(UpLoadFile upLoadFile);

    UpLoadFile selectBase64ById(int id);
}
