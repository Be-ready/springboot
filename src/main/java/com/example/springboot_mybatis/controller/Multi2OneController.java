package com.example.springboot_mybatis.controller;

import com.example.springboot_mybatis.Mapper.IAccountMapper;
import com.example.springboot_mybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Multi2OneController {

    @Autowired
    IAccountMapper iAccountMapper;

    @GetMapping("/multi/findall")
    public void findAll(){

        List<Account> accounts = iAccountMapper.findAll();
        for (Account account:accounts){
            System.out.println(account.toString());
            System.out.println(account.getUser());
        }
    }

    @GetMapping("/multi/getById/{id}")
    public Account getById(@PathVariable("id") Integer id){

        System.out.println(iAccountMapper.getById(id));
        return iAccountMapper.getById(id);
    }

}

