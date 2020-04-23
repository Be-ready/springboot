package com.example.springboot_mybatis.Mapper;

import com.example.springboot_mybatis.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface IAccountMapper {

    // 用于多对一查询（查询account表的全部信息时，查出每条信息的拥有者user表中信息）
    @Select("select * from account")
    @Results(id = "accountMap",
            value = {
//                    @Result(column = "id",property = "id"), // 实验得知，主键id可不写
                    @Result(column = "uid",property = "uid"),  // 必须写，不然会是null
//                    @Result(column = "money",property = "money"),  // 该行也可不写
                    @Result(column = "uid",  // 此处的uid是account表的外键，会传到下方select语句中的getById方法中
                                              // 根据它来关联查询，如果修改，则查不到结果
                    property = "user",  // 对应account实体类中对User实体类的引用
                    one = @One(select = "com.example.springboot_mybatis.Mapper.IUserMapper.getById"))
            })
    List<Account> findAll();

    // 用于多对一查询（查询account表的某一条信息时，查出其拥有者user表中信息）
    @Select("select * from account where id=#{id}")
    @Results(value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "uid", property = "user", one = @One(select = "com.example.springboot_mybatis.Mapper.IUserMapper.getById"))
    })
    Account getById(Integer id);

    // 用于一对多查询（查询user表时，一起查出其拥有的account表中的信息）（用于IUser2Mapper.java）
    @Select("select * from account where uid=#{uid}")
    Account getByUid(Integer uid);
}
