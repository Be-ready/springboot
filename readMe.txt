代码功能：
    在springboot整合mybatis的基础上实现：(使用注解版)
        1、单表的增删改查
        2、多表的增删改查（一对多，多对一）
    sql语句：
        use springboot
        create table user(id Integer primary key auto_increment,
        					username varchar(40),
        					sex varchar(1),
        					address varchar(200),
        					boss boolean)
        insert into user (username,sex,address,boss) values("张三","男","河南",false);
        insert into user (username,sex,address,boss) values("Lisa","女","美国",false);
        insert into user (username,sex,address,boss) values("六五三","男","北京",false);
        insert into user (username,sex,address,boss) values("王歌","男","信阳",true);

        create table account(id Integer primary key auto_increment,
        					uid Integer,
        					money double,
        					foreign key(uid) references user(id)  ON DELETE CASCADE)
        // ON DELETE CASCADE：级联删除
        insert into account(uid, money) values(4,5940000)
        insert into account(uid, money) values(2,400000)
        insert into account(uid, money) values(3,210000)
        insert into account(uid, money) values(2,210000)
        insert into account(uid, money) values(3,500000)
        insert into account(uid, money) values(1,350000)
        insert into account(uid, money) values(3,6900000)
        insert into account(uid, money) values(4,500000)
        insert into account(uid, money) values(3,4444000)
        insert into account(uid, money) values(2,2140000)

https://github.com/Be-ready/springboot.git