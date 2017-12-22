-- 字典表
create table hobby(
    id number(10) primary key,
    name varchar(50),
    code number(6)
);
create sequence hobby_id start with 0 increment by 1 minvalue 0 maxvalue 9999;
insert into hobby values(hobby_id.nextval,'听音乐',1);
insert into hobby values(hobby_id.nextval,'运动',2);
insert into hobby values(hobby_id.nextval,'读书',3);
insert into hobby values(hobby_id.nextval,'爬山',4);
insert into hobby values(hobby_id.nextval,'写作',5);
commit;

select * from hobby; 

drop table hobby; 
drop sequence hobby_id;

-- 创建城市和省份表
create table nativePlace(
    id number(10) primary key,
    name varchar2(50),
    code varchar2(6)
);
-- 为表中的某一个字段添加唯一约束
alter table nativePlace add constraint unique_code unique(code);
-- 查询城市和省份
select * from nativePlace;
-- 创建一个序列
create sequence nativePlace_id start with 0 increment by 1 minvalue 0 maxvalue 9999;

-- 往表中插入数据
insert into nativePlace values(nativePlace_id.nextval,'北京','01');
insert into nativePlace values(nativePlace_id.nextval,'朝阳区','0101');
insert into nativePlace values(nativePlace_id.nextval,'海淀区','0102');
insert into nativePlace values(nativePlace_id.nextval,'山东','37');
insert into nativePlace values(nativePlace_id.nextval,'青岛','3702');
insert into nativePlace values(nativePlace_id.nextval,'济南','3701');
insert into nativePlace values(nativePlace_id.nextval,'潍坊','3707');
commit;

-- 删除省份和城市表
drop table nativePlace;
-- 删除序列
drop sequence nativePlace_id;

-- 创建 users 表
create table users(
   id number(10) primary key,
   name varchar2(50),
   password varchar2(50),
   sex char(1) default '1',
   email varchar2(100)
);
-- 创建一个序列（sequence），在新增表数据（插入一条记录时），为主键赋自增值。
create sequence users_id start with 0 increment by 1 minvalue 0 maxvalue 9999;
-- 查询 users 表
select * from users;
-- 往表中插入数据
insert into users values (users_id.nextval,'admin','admin','1','albert@qq.com');
commit;

drop sequence users_id;
drop table users;

-- 创建用户详情表
create table userDetails(
    id number(10) primary key,
    nativeplace_code varchar2(6) references nativePlace(code),
    hobby_code varchar2(50)
);
-- 为用户详情表创建主键自增序列
create sequence userDetails_id start with 0 increment by 1 minvalue 0 maxvalue 9999;
-- 查询 userDetails
select * from userDetails;
-- 删除序列 userDetails_id
drop sequence userDetails_id;
-- 删除表 userDetails
drop table userDetails;

select * from userDetails;

select * from users;

select u.id,u.name,u.password,u.sex,u.email,np.name,ud.hobby_code from users u  left outer join UserDetails ud on u.id=ud.id 
left outer join nativePlace np on ud.nativePlace_code=np.code;
