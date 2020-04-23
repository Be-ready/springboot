package com.example.springboot_mybatis.entity;

import java.io.Serializable;

public class Account{

    private Integer id;
    private Integer uid;
    private double money;

    // 账户和用户是多对一关系（一个用户可以有多个账户）
    // 多对一关系映射:从表方应该包含一个主表方的对象引用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

