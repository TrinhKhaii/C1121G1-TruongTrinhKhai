create database sales_manager;

use sales_manager;

create table Customer (
	cId   int         not null auto_increment primary key,
    cName varchar(50) not null,
    cAge  int         not null
);

create table `Order` (
	oId int not null auto_increment primary key,
    cId int not null,
    oDate datetime not null,
    oTotalPrice float default 0,
    foreign key (cId) references Customer (cId)
);

create table Product(
	pId int not null auto_increment primary key,
    pName varchar(50) not null,
    pPrice float not null
);

create table OrderDetail (
	oId int not null,
    pId int not null,
    odQTY varchar(50) not null,
    foreign key (oId) references `Order` (oId),
    foreign key (pId) references Product (pId)
);
