package com.example.springboot_mybatis.entity;

import java.io.Serializable;

public class User{

    private Integer id;
    private String username;
    private String sex;
    private String address;
    private boolean boss;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", boss=" + boss +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
}
