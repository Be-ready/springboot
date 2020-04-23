package com.example.springboot_mybatis.entity;

import java.util.List;

public class User2 {

    private Integer id;
    private String username;
    private String sex;
    private String address;
    private boolean boss;

    //一对多关系映射:主表方法应该包含一个从表方的集合引用(不必重写它的toString方法)
    private List<Account> accounts;

    @Override
    public String toString() {
        return "User2{" +
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
