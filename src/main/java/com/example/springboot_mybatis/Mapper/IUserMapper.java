package com.example.springboot_mybatis.Mapper;

import com.example.springboot_mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface IUserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    // ${username} 从主配置文件（application.yml）中读取
    @Update("update user set username=${username}, boss=${boss} where id=#{id}")
    int update(Integer id);

//    @Update("update user set username=${person.username}, boss=${person.boss} where id=#{id}")
//    void update2(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into user (username, sex, boss, address) values(#{username}, #{sex}, #{boss}, #{address})")
    void insert(User user);

    @Select("select * from user where username=#{username}")
    User getByName(String username);
}
