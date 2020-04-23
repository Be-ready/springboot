package com.example.springboot_mybatis.controller;

import com.example.springboot_mybatis.Mapper.IUserMapper;
import com.example.springboot_mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 在user表的基础上实现增删改查

@RestController
public class One2OneController {

    @Autowired
    IUserMapper IUserMapper;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return IUserMapper.getById(id);
    }

    @GetMapping("/update/{id}")
    public Map<String, Object> updateUser(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("修改前", IUserMapper.getById(id));
        IUserMapper.update(id);
        map.put("修改后", IUserMapper.getById(id));
        return map;
    }

    @GetMapping("/getall")
    public List<User> getAll(){

        return IUserMapper.findAll();
    }

    @GetMapping("/delete/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") Integer id){

        Map<String,Object> map = new HashMap<>();
        map.put("删除前", IUserMapper.getById(id));
        IUserMapper.deleteById(id);
        map.put("删除后", IUserMapper.getById(id));
        return map;
    }

    @GetMapping("/insert")
    public Map<String,Object> insert(User user){

        Map<String,Object> map = new HashMap<>();
        map.put("删除前", IUserMapper.getByName(user.getUsername()));
        user.setAddress("淮滨");
        user.setBoss(false);
        user.setSex("女");
        user.setUsername("青青");
        IUserMapper.insert(user);
        map.put("删除后", IUserMapper.getByName(user.getUsername()));
        return map;
    }
}
