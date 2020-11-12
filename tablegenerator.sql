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
insert into user value('1', 'Aasav Badera', 'aasavbadera', '$2a$10$2yi5mea10Sm.w68No2FwHOck/Yti4InPJZPWDq6LJ5PnKi5w4w8fi', 'aasav.badera@gmail.com', 'BNZAA2318J', '06BZAHM6385P6Z2', NULL, 'h-2', NULL, 'kota', '324005', '9782565081', NULL);
insert into user value('2', 'Aasav Badera', 'aasavbadera1', '$2a$10$TRnAOfWfJow8B4XR2C2OwOxbqgHAOSK.oOaro3CXT.pyxkfehzX7O', 'aasav.badera1@gmail.com', 'BNAAA2318J', '06BZAHM6485P6Z2', NULL, 'Room Number - 9, C. V. Raman Hostel,', NULL, 'Varanasi, Uttar Pradesh', '221005', '9782565081', NULL);

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
insert into users_roles value(1,1);
insert into users_roles value(2,1);

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
name varchar(50) not null,
primary key(id),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
unique(name, username_id)
);
insert into schedules value(1,'kisan','aasavbadera');
insert into schedules value('2', 'Crops', 'aasavbadera');
drop table if exists group_s;
create table group_s(
id int not null auto_increment,
groupname varchar(50) not null,
schedulename int not null,
primary key(id),
foreign key(schedulename) references schedules(id) on delete cascade
);
insert into group_s value('1', 'Badaud', '1');
insert into group_s value(
'2', 'Rabi', '2'
);
drop table if exists accounts;
create table accounts(
id int not null auto_increment,
accountname varchar(60) not null,
guarantorname varchar(50) not null,
groupname int not null,
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
foreign key(groupname) references group_s(id) on delete cascade
);
insert into accounts value(
'1', 'Yay', 'Pradeep Kumar', '1', NULL, NULL, '9782565081', NULL, NULL, NULL, 'Room Number - 9, C. V. Raman Hostel,', 'Varanasi, Uttar Pradesh', '221005');
insert into accounts value('2', 'Dharma', 'Pradeep', '1', '123', NULL, '9782565081', NULL, NULL, NULL, 'Room Number - 9, C. V. Raman Hostel,', 'Varanasi, Uttar Pradesh', '221005');

drop table if exists tax;
create table tax(
id int not null auto_increment,
taxtype varchar(50) not null,
username_id int not null,	
taxrate varchar(50) not null default 0,
foreign key(username_id) references user(id) on delete cascade,
primary key(id),
unique(taxtype, taxrate)
);
insert into tax value(
'1', 'CGST', '1', '5'
);
insert into tax value(
'2', 'SGST', '1', '6'
);
insert into tax value(
'3', 'GSTIN', '1', '10'
);
drop table if exists stockitem;
create table stockitem(
id int not null auto_increment,
primary key(id),
quantity int not null,
itemname varchar(50) not null,
hsngroup varchar(50),
manditax varchar(50) not null,
kkfee varchar(50) not null,
commision varchar(50) not null,
labourcharge varchar(50) not null,
packing varchar(50) not null,
groupname int not null,
foreign key(groupname) references group_s(id) on delete cascade
);
insert into stockitem value(
'1', '1', 'Wheat', NULL, '5', '6', '4', '2', '1', '1'
);
insert into stockitem value(
'2', '2','Corn', NULL, '2', '4', '2', '8', '1', '2'
);
drop table if exists stock_tax;
create table stock_tax(
	id int unique not null auto_increment,
	stock_id int not null,
    tax_id int not null,
    primary key(id),
    foreign key(stock_id) references stockitem(id),
    foreign key(tax_id) references tax(id),
    unique(stock_id, tax_id)
);
insert into stock_tax(id, stock_id, tax_id) values
('1', '1', '1'),
('3', '2', '1'),
('2', '2', '3');
drop table if exists journalvoucher;
create table journalvoucher(
jvoucherid int not null auto_increment,
date date not null,
credittotal varchar(50) not null default 0,
debittotal varchar(50) not null default 0,
accountid int not null,
description text ,
primary key(jvoucherid),
username_id varchar(50) not null,
name varchar(50),
foreign key(accountid) references accounts(id) on delete cascade,
foreign key(username_id) references user(username) on delete cascade
);
insert into journalvoucher(jvoucherid, date, credittotal, debittotal, accountid, description, username_id, name) values
('1', '2020-11-08', '24.14', '324.15', '1', 'NA', 'aasavbadera', 'Yay'),
('2', '2020-11-08', '32.24', '21.31', '1', NULL, 'aasavbadera', 'Yay'),
('3', '2020-11-14', '511.15', '21.3', '2', 'Loss', 'aasavbadera', 'Dharma'),
('4', '2020-12-30', '123.14', '0.0', '1', 'Prof', 'aasavbadera', 'Yay'),
('5', '2020-11-26', '21313.14', '123.1', '2', 'heavy profit', 'aasavbadera', 'Dharma');

drop table if exists bankvoucher;
create table bankvoucher(
bvoucherid int not null auto_increment,
date date not null,
credittotal varchar(50) not null default 0,
description text ,
accountid int not null,
debittotal varchar(50) not null default 0,
name varchar(50),
primary key(bvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(accountid) references accounts(id) on delete cascade
);

insert into bankvoucher(bvoucherid, date, credittotal, description, accountid, debittotal, name, username_id) values
('1', '2020-11-01', '12314.0', 'Cheque Id - 521421', '2', '0.0', 'Dharma', 'aasavbadera'),
('2', '2020-11-09', '4123.14', 'Id - 3', '2', '3162.4', 'Dharma', 'aasavbadera'),
('3', '2020-11-11', '2131.0', 'id = 4', '1', '21984.1', 'Yay', 'aasavbadera'),
('4', '2020-11-12', '348725.12', 'just random text', '2', '1.0', 'Dharma', 'aasavbadera'),
('5', '2020-11-03', '5238.0', 'NAN', '1', '1234.0', 'Yay', 'aasavbadera');

drop table if exists cashvoucher;
create table cashvoucher(
cvoucherid int not null auto_increment,
date date not null,
description text ,
credittotal varchar(50) not null default 0,
debittotal varchar(50) not null default 0,
name varchar(50),
accountid int not null,
primary key(cvoucherid),
username_id varchar(50) not null,
foreign key(username_id) references user(username) on delete cascade,
foreign key(accountid) references accounts(id) on delete cascade
);

drop table if exists purchasebill;
create table purchasebill(
pvoucherid int not null auto_increment,
trucknumber varchar(50),
cost Double,
currdate date not null,
suppliername varchar(50) not null,
description text,
supplierid int not null,
primary key(pvoucherid),
username_id varchar(50) not null,
tax double,
foreign key(username_id) references user(username) on delete cascade,
foreign key(supplierid) references accounts(id) on delete cascade
);
insert into purchasebill value ('1', NULL, '10.3', '2020-11-03', 'Yay', NULL, '1', 'aasavbadera', NULL);
drop table if exists salebill;
create table salebill(
svoucherid int not null auto_increment,
cost double,
currdate date not null,
username_id varchar(50) not null,
suppliername varchar(50) not null,
supplierid int not null,
description text,
foreign key(username_id) references user(username) on delete cascade,
foreign key(supplierid) references accounts(id) on delete cascade,
trucknumber varchar(50),
tax double,
primary key(svoucherid)
);
drop table if exists saleitems;
create table saleitems(
id int not null auto_increment,
primary key(id),
quantity varchar(50) not null default 0,
rate varchar(50) not null default 0,
svoucherid int not null,
itemname varchar(50) not null,
totalamount double,
tax double,
taxbreakup text,
foreign key(svoucherid) references salebill(svoucherid) on delete cascade,
unique(quantity, rate, svoucherid, itemname)
);
drop table if exists purchaseitems;
create table purchaseitems(
id int not null auto_increment,
primary key(id),
quantity int not null default 0,
rate double not null default 0,
totalamount double,
taxbreakup text,
tax double,
pvoucherid int not null,
itemname varchar(50) not null,
foreign key(pvoucherid) references purchasebill(pvoucherid) on delete cascade,
unique(quantity, rate, pvoucherid, itemname)
);
insert into purchaseitems values 
('1', '0', '1', '2.44', 'Total tax:Rs.0.44(22.00%: KKFee:6.00% Commision:4.00% Labour Charge:2.00% Mandi Tax:5% CGST:5%', '0.44', '1', 'Wheat'),
('2', '0', '2', '7.86', 'Total tax:Rs.1.86(31.00%: KKFee:4.00% Commision:2.00% Labour Charge:8.00% Mandi Tax:2% CGST:5% GSTIN:10%', '1.86', '1', 'Corn');
drop table if exists current_availability;
create table current_availability(
id int not null auto_increment,
stock_id int not null,
quantity int not null,
primary key(id),
foreign key(stock_id) references stockitem(id)
);
