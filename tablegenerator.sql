-- Script written so as to be able to generate the schema tables
drop database if exists `merchant-manager`;
create database if not exists `merchant-manager`;
use `merchant-manager`;
-- Table creation script
DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
  id int not null auto_increment,
  displayname varchar(50) not null,
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  email varchar(50) not null unique,
  pan varchar(50) not null unique,
  gstin varchar(50) not null unique,
  tdsaccountnumber varchar(50) default null,
  addressline1 varchar(100) not null default "-",
  addressline2 varchar(100) default null,
  city varchar(100) not null default "-",
  pincode varchar(50) not null default "-",
  mobilenumber1 varchar(50) not null,
  mobilenumber2 varchar(50) ,
  PRIMARY KEY (id),
  unique(username)
);
drop table if exists role;
create table role(
id int not null auto_increment,
name varchar(50) default "ROLE_EMPLOYEE",
primary key(id)
);
insert into role value(1, 'ROLE_EMPLOYEE');
-- insert into role values ("ROLE_EMPLOYEE");user_roles
drop table if exists users_roles;
create table users_roles(
user_id int not null,
role_id int not null,
primary key(user_id, role_id),
foreign key(user_id) references user(id),
foreign key(role_id) references role(id)
);
-- INSERT INTO `user` 
-- VALUES 
-- ('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE authorities (
  username_id int NOT NULL,
  authority varchar(50) NOT NULL,
  foreign key(username_id) references user(id) on delete cascade
);


-- INSERT INTO `authorities`
-- VALUES 
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_ADMIN');

-- drop table if exists companymobilenumber;
-- create table companymobilenumber(
-- id int not null auto_increment,
-- mobileno varchar(50) not null,
-- username_id varchar(50) not null,
-- primary key(id),
-- foreign key(username_id) references user(username) on delete cascade
-- );
-- drop table if exists companyemail;
-- create table companyemail(
-- id int not null auto_increment,
-- email varchar(50) not null,
-- username_id varchar(50) not null,
-- primary key(id),
-- foreign key(username_id) references user(username) on delete cascade
-- );
drop table if exists schedules;
create table schedules(
id int not null auto_increment,
name varchar(50) not null unique,
primary key(id)
);
drop table if exists group_s;
create table group_s(
id int not null auto_increment,
groupname varchar(50) not null unique,
schedulename varchar(50) not null,
primary key(id),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(schedulename) references schedules(name) on delete cascade
);
drop table if exists accounts;
create table accounts(
id int not null auto_increment,
accountname varchar(60) not null unique,
guarantorname varchar(50) not null,
groupname varchar(50) not null,
HSNnumber varchar(50) default 'NA',
email varchar(50),
mobilenumber1 varchar(50) not null,
mobilenumber2 varchar(50),
PAN varchar(50),
addressline2 varchar(100) default null,
addressline1 varchar(100) not null,
city varchar(100) default null,
pincode varchar(50) default null,
primary key(id),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(groupname) references group_s(groupname) on delete cascade
);
drop table if exists journalvoucher;
create table journalvoucher(
jvoucherid int not null auto_increment,
date varchar(50) not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
primary key(jvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists bankvoucher;
create table bankvoucher(
bvoucherid int not null auto_increment,
date varchar(50) not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
primary key(bvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists cashvoucher;
create table cashvoucher(
cvoucherid int not null auto_increment,
date varchar(50) not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
description varchar(100) not null default '-',
primary key(cvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists banktransactions;
create table banktransactions(
id int not null auto_increment,
name varchar(50) not null,
bvoucherid int not null,
amount double not null default 0,
iscredit bool not null default false,
description varchar(100) not null default '-',
primary key(id),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key (name) references accounts(name) on delete cascade, 
foreign key(bvoucherid) references bankvoucher(bvoucherid) on delete cascade,
unique(amount, bvoucherid, iscredit, name)
);
drop table if exists journaltransactions;
create table journaltransactions(
id int not null auto_increment,
primary key(id),
name varchar(50) not null,
jvoucherid int not null,
amount double not null default 0,
iscredit bool not null default false,
description varchar(100) not null default '-',
foreign key (name) references accounts(name) on delete cascade,
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(jvoucherid) references journalvoucher(jvoucherid) on delete cascade,
unique(amount, jvoucherid, iscredit, name)
);
drop table if exists stockitem;
create table stockitem(
id int not null auto_increment,
primary key(id),
itemname varchar(50) not null,
closingstock double not null,
hsngroup varchar(50) not null,
manditax double not null,
kkfee double not null,
commision double not null,
labourcharge double not null,
packing double not null,
openingstock double not null,
groupname varchar(50) not null,
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(groupname) references group_s(groupname) on delete cascade
);
drop table if exists purchasebill;
create table purchasebill(
pvoucherid int not null auto_increment,
trucknumber varchar(50),
fixedcost double not null default 0,
currdate varchar(50) not null,
iscredit bool not null default false,
suppliername varchar(50) not null,
primary key(pvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(suppliername) references group_s(groupname) on delete cascade
);
drop table if exists tax;
create table tax(
id int not null auto_increment,
primary key(id),
taxtype varchar(50) not null,
itemname varchar(50) not null,
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
taxrate double not null default 0,
foreign key(itemname) references stockitem(itemname) on delete cascade,
unique(taxtype, itemname)
);
drop table if exists salebill;
create table salebill(
svoucherid int not null auto_increment,
iscredit bool not null default false,
currdate varchar(50) not null,
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
trucknumber varchar(50) not null default '-',
primary key(svoucherid)
);
drop table if exists saleitems;
create table saleitems(
id int not null auto_increment,
primary key(id),
quantity varchar(50) not null default 0,
rate double not null default 0,
svoucherid int not null,
itemname varchar(50) not null,
foreign key(svoucherid) references salebill(svoucherid) on delete cascade,
unique(quantity, rate, svoucherid, itemname)
);
drop table if exists purchaseitems;
create table purchaseitems(
id int not null auto_increment,
primary key(id),
quantity varchar(50) not null default 0,
rate double not null default 0,
pvoucherid int not null,
itemname varchar(50) not null,
foreign key(pvoucherid) references purchasebill(pvoucherid) on delete cascade,
unique(quantity, rate, pvoucherid, itemname)
);
