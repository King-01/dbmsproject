-- Script written so as to be able to generate the schema tables
drop database if exists `merchant-manager`;
create database if not exists `merchant-manager`;
use `merchant-manager`;
-- Table creation script
DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY (username)
);

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  foreign key(username) references users(username) on delete cascade
);


INSERT INTO `authorities`
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');

drop table if exists financialyear;
create table financialyear(
finyear year not null,
username varchar(50) not null,
primary key(finyear),
foreign key(username) references users(username) on delete cascade
);

drop table if exists companymobilenumber;
create table companymobilenumber(
mobileno bigint not null,
username varchar(50) not null,
primary key(mobileno),
foreign key(username) references users(username) on delete cascade
);
drop table if exists companyemail;
create table companyemail(
email varchar(50) not null,
username varchar(50) not null,
primary key(email),
foreign key(username) references users(username) on delete cascade
);
drop table if exists company;
create table company(
username varchar(50) not null,
pan bigint not null unique,
openingbalance double not null default 0,
gstin bigint default null,
tdsaccountnumber bigint default null,
addressline1 varchar(100) default null,
addressline2 varchar(100) default null,
city varchar(100) default null,
pincode int default null,
foreign key(username) references users(username) on delete cascade
);
drop table if exists schedules;
create table schedules(
name varchar(50) not null,
iscredit bool not null,
scheduletype varchar(50) not null,
primary key(name)
);
drop table if exists group_s;
create table group_s(
groupname varchar(50) not null,
schedulename varchar(50) not null,
primary key(groupname),
foreign key(schedulename) references schedules(name) on delete cascade
);
drop table if exists accounts;
create table accounts(
accountname varchar(60) not null,
openingbalance double not null default 0,
guarantorname varchar(50) not null,
groupname varchar(50) not null,
HSNnumber varchar(50) default 'NA',
PAN varchar(50),
addressline2 varchar(100) default null,
city varchar(100) default null,
pincode int default null,
primary key(accountname),
foreign key(groupname) references group_s(groupname) on delete cascade
);
drop table if exists accountmobilenumber;
create table accountmobilenumber(
accountname varchar(50) not null,
mobilenumber bigint not null,
primary key(mobilenumber),
foreign key(accountname) references accounts(accountname) on delete cascade
);
drop table if exists accountemailid;
create table accountemailid(
accountname varchar(50) not null,
email varchar(50) not null,
primary key(email),
foreign key(accountname) references accounts(accountname) on delete cascade
);
drop table if exists journalvoucher;
create table journalvoucher(
jvoucherid bigint not null auto_increment,
date date not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
primary key(jvoucherid),
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists bankvoucher;
create table bankvoucher(
bvoucherid bigint not null auto_increment,
date date not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
primary key(bvoucherid),
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists cashvoucher;
create table cashvoucher(
cvoucherid bigint not null auto_increment,
date date not null,
credittotal double not null default 0,
debittotal double not null default 0,
name varchar(50) not null,
description varchar(100) not null default '-',
amount double not null default 0,
primary key(cvoucherid),
foreign key(name) references accounts(accountname) on delete cascade
);
drop table if exists banktransactions;
create table banktransactions(
name varchar(50) not null,
bvoucherid bigint not null,
amount double not null default 0,
iscredit bool not null default false,
description varchar(100) not null default '-',
foreign key(bvoucherid) references bankvoucher(bvoucherid) on delete cascade,
unique(amount, bvoucherid, iscredit, name)
);
drop table if exists journaltransactions;
create table journaltransactions(
name varchar(50) not null,
jvoucherid bigint not null,
amount double not null default 0,
iscredit bool not null default false,
description varchar(100) not null default '-',
foreign key(jvoucherid) references journalvoucher(jvoucherid) on delete cascade,
unique(amount, jvoucherid, iscredit, name)
);
drop table if exists stockitem;
create table stockitem(
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
primary key(itemname),
foreign key(groupname) references group_s(groupname) on delete cascade
);
drop table if exists purchasebill;
create table purchasebill(
pvoucherid bigint not null auto_increment,
trucknumber varchar(50),
fixedcost double not null default 0,
currdate date not null,
iscredit bool not null default false,
suppliername varchar(50) not null,
primary key(pvoucherid),
foreign key(suppliername) references group_s(groupname) on delete cascade
);
drop table if exists tax;
create table tax(
taxtype varchar(50) not null,
itemname varchar(50) not null,
taxrate double not null default 0,
foreign key(itemname) references stockitem(itemname) on delete cascade,
unique(taxtype, itemname)
);
drop table if exists salebill;
create table salebill(
svoucherid bigint not null auto_increment,
iscredit bool not null default false,
currdate date not null,
trucknumber varchar(50) not null default '-',
primary key(svoucherid)
);
drop table if exists saleitems;
create table saleitems(
quantity bigint not null default 0,
rate double not null default 0,
svoucherid bigint not null,
itemname varchar(50) not null,
foreign key(svoucherid) references salebill(svoucherid) on delete cascade,
unique(quantity, rate, svoucherid, itemname)
);
drop table if exists purchaseitems;
create table purchaseitems(
quantity bigint not null default 0,
rate double not null default 0,
pvoucherid bigint not null,
itemname varchar(50) not null,
foreign key(pvoucherid) references purchasebill(pvoucherid on delete cascade,
unique(quantity, rate, pvoucherid, itemname)
);
