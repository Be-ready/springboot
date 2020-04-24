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

修改错误：One2OneController.java中
第一处：
  @GetMapping("/update/{id}")
    public Map<String, Object> updateUser(@PathVariable("id") Integer id){

        Map<String,Object> map = new HashMap<>();

//        User user = IUserMapper.getById(id);
//        map.put("修改前", user);  // 会出现修改前和修改后数据除了性别改变其他没差别的问题
        map.put("修改前", IUserMapper.getById(id));

        User user = IUserMapper.getById(id);
        user.setUsername("张胡子");
        user.setSex("女");
        user.setBoss(false);

        IUserMapper.update(user);
        map.put("修改后", IUserMapper.getById(id));
        return map;
    }

第二处：
    @GetMapping("/insert")
    public Map<String,Object> insert(User user){

        Map<String,Object> map = new HashMap<>();
        user.setAddress("淮滨");
        user.setBoss(false);
        user.setSex("女");
        user.setUsername("青青");
        map.put("插入前", IUserMapper.getByName(user.getUsername()));
        IUserMapper.insert(user);
        map.put("插入后", IUserMapper.getByName(user.getUsername()));
        return map;
    }
