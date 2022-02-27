create database sales_manager;

use sales_manager;

create table customer (
	c_id   int         not null auto_increment primary key,
    c_name varchar(25) not null,
    c_age  tinyint         not null
);

create table `order` (
	o_id int not null auto_increment primary key,
    c_id int not null,
    o_date date not null,
    o_total_price float default 0,
    foreign key (c_id) references customer (c_id)
);

create table product(
	p_id int not null auto_increment primary key,
    p_name varchar(25) not null,
    p_price float not null
);

create table order_detail (
	o_id int not null,
    p_id int not null,
    od_qty int not null,
    foreign key (o_id) references `order` (o_id),
    foreign key (p_id) references product (p_id)
);
