package com.example.demo.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -653301662892836854L;
    private Long id;
    private Integer height;
    private String name;
    private String password;
    private String des;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
