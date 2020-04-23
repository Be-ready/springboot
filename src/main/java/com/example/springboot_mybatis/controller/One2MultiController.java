package com.example.springboot_mybatis.controller;

import com.example.springboot_mybatis.Mapper.IUser2Mapper;
import com.example.springboot_mybatis.entity.User;
import com.example.springboot_mybatis.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class One2MultiController {

    @Autowired
    IUser2Mapper iUser2Mapper;

    @GetMapping("/one2multi/findall")
    public List<User2> findAll(){

        for(User2 user: iUser2Mapper.findAll()){
            System.out.println((user.toString()));
            System.out.println(user.getAccounts());
        }
        return iUser2Mapper.findAll();
    }

    @GetMapping("/one2multi/getById/{id}")
    public User2 getById(@PathVariable("id") Integer id){

        return iUser2Mapper.getById(id);
    }
}
