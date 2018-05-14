package com.example.demo.model;

import java.io.Serializable;

public class UpLoadFile implements Serializable {
    private Integer id;
    private String filepath;
    private String base64;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "UpLoadFile{" +
                "id=" + id +
                ", filepath='" + filepath + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
