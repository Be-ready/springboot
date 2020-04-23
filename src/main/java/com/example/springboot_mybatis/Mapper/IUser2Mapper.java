package com.example.springboot_mybatis.Mapper;

import com.example.springboot_mybatis.entity.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUser2Mapper {

    // 一对多查询（查询user表全部数据时，查出所有user拥有的账户account表中信息）
    @Select("select * from user")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id",property = "accounts",  // user表中的id对应account表中的uid，
                                                          // 所以要用IAccountMapper中的getByUid
                    many=@Many(select = "com.example.springboot_mybatis.Mapper.IAccountMapper.getByUid"))
    })
    List<User2> findAll();

    // 一对多查询（查询user表中的一条数据时，查出其拥有的账户account表中信息）
    @Select("select * from user where id=#{id}")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "accounts",  // user表中的id对应account表中的uid，
                                                           // 所以要用IAccountMapper中的getByUid
                    many = @Many(select = "com.example.springboot_mybatis.Mapper.IAccountMapper.getByUid"))
    })
    User2 getById(Integer id);
}
