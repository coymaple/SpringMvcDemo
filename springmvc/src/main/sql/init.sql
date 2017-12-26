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
-- 查询 hobby 表
select * from hobby; 
-- 删除 hobby 表
drop table hobby; 
-- 删除 hobby_id 序列
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

-- 两张表之间的连接 user 和 userDetail 左连接。
select u.id,u.name,u.password,u.sex,u.email,np.name,ud.hobby_code from users u  left outer join UserDetails ud on u.id=ud.id 
left outer join nativePlace np on ud.nativePlace_code=np.code where u.name like 't%';

-- 创建权限表 permission 
create table permission(
    id number(10) primary key,
    url varchar2(200) default '',
    name varchar2(50),
    parentId number(10),
    remark varchar2(200) default ''
);
-- 创建 permission_id 序列
create sequence permission_id start with 1 increment by 1 minvalue 0 ;
insert into permission (id,name,parentId) values (permission_id.nextval,'用户管理模块',0);
insert into permission (id,name,parentId) values (permission_id.nextval,'邮件管理模块',0);
select * from permission;
insert into permission values (permission_id.nextval,'userInit.mvc','用户信息管理',1,'用户信息管理');
insert into permission values (permission_id.nextval,'#','用户权限管理',1,'用户权限管理');
insert into permission values (permission_id.nextval,'#','用户角色管理',1,'用户角色管理');
insert into permission values (permission_id.nextval,'#','收邮件',2,'收邮件');
insert into permission values (permission_id.nextval,'#','写邮件',2,'写邮件');
insert into permission values (permission_id.nextval,'#','垃圾邮件',2,'垃圾邮件');
commit;

drop sequence permission_id;
drop table permission;

-- 分页
select * from users;
-- 分页需要的数据：当前要显示页的页数（currentPage），每页的行数（固定的数据,rowNumber）。
-- 分页公式：(currentPage-1)*rowNumber
-- oracle 分页特殊性：利用 rowNum 进行分页，该数据只能小于不能大于。
select u.*,rowNum from users u where rowNum>1; --无数据
-- 原因：rowNum是在表生成的阶段自动生成的，如果大于某个值，rowNum永远不可能大于1
-- 当前页为第二页
--1,获取要分页的数据
select * from users;
--2，去尾
select bt.*,rowNum rn from (select * from users) bt where rowNum<(2)*2;
--3，去头,获得最终数据
select * from (select bt.*,rowNum rn from (select * from users) bt where rowNum<(2)*2) mt where rn>(2-1)*2;


-- 业务分页
select * from (select bt.*,rowNum rn from ( 
 select u.id id,u.name name,u.password password,u.sex sex,u.email email,np.name nativePlaceName,ud.hobby_code hobbyCode from users u  left outer join UserDetails ud on u.id=ud.id 
left outer join nativePlace np on ud.nativePlace_code=np.code 
 ) bt where rowNum<(2)*2) mt where rn>(2-1)*2;
-- 带查询的业务分页
select * from (select bt.*,rowNum rn from ( 
 select u.id id,u.name name,u.password password,u.sex sex,u.email email,np.name nativePlaceName,ud.hobby_code hobbyCode from users u  left outer join UserDetails ud on u.id=ud.id 
left outer join nativePlace np on ud.nativePlace_code=np.code where u.name like 't'
 ) bt where rowNum<(2)*2) mt where rn>(2-1)*2;

-- 获取总行数。 count(1) 可被替换为 count(*)， 区别在于 count(1) 效率更高
 select count(1) from users u  left outer join UserDetails ud on u.id=ud.id 
left outer join nativePlace np on ud.nativePlace_code=np.code;


create table role(
	id number(10) primary key,
	name varchar2(50),
	remark varchar2(200)
);

insert into role values (role_id.nextval,"用户管理","用户权限管理");

create table userRole(
	id mumber(10) primary key,
	usersId number(10) reference users(id),
	roleId number(10) reference role(id)
);



create table rolePermission(
	id mumber(10) primary key,
	permissionId number(10) reference permission(id),
	roleId number(10) reference role(id)
);

insert into rolePermission values(rolePermission_id.nextval,3,1);
insert into rolePermission values(rolePermission_id.nextval,4,1);
insert into rolePermission values(rolePermission_id.nextval,5,1);
commit;


insert into userRole values (usserRole_id.nextVal,1,1);
commit;

select * from user u  left outer join userRole ur on u.id=ur.usersId
left outer join rolePermission rp on ur.id=rp.permissionId
left outer join  permission p on p.id=up.permission
where u.id=1;






