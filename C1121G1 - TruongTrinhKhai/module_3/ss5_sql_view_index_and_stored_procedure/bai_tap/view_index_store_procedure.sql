-- Bước 1
create database demo;

use demo;

-- Bước 2
create table products(
	id int auto_increment not null,
	product_code varchar(20),
	product_name varchar(45),
	product_price double,
	product_amount int,
	product_description varchar(100),
	product_status bit(1),
    primary key(id)
);

insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
values ('1', 'S10_1678', '1969 Harley Davidson Ultimate Chopper', '95.34', '56', 'abc',1),
	   ('2','S10_1949','1952 Alpine Renault 1300','96.34','57','abc',0),
	   ('3','S10_2016','1996 Moto Guzzi 1100i','97.34','58','abc',1),
	   ('4','S10_4698','2003 Harley-Davidson Eagle Dragike','98.34','59','abc',1),
	   ('5','S10_4757','1972 Alfa Romeo GTA','99.34','60','abc',0),
	   ('6','S10_4962','1962 LanciaA Delta 16V','100.34','61','abc',0),
	   ('7','S12_1099','1968 Ford Mustang','101.34','62','abc',1);

select * from products;
       
-- Bước 3
explain select * from products
where product_code = 'S12_1099';
create index product_code_idx
on products(product_code);
explain select * from products
where product_code = 'S12_1099';

explain select * from products
where product_name = '1952 Alpine Renault 1300' and product_price = 95.34;
create index product_name_and_price_idx
on products(product_name, product_price);
explain select * from products
where product_name = '1952 Alpine Renault 1300' and product_price = 95.34;

-- Bước 4
create view products_views as select product_code, product_name, product_price, product_status from products;
select * from products_views;
insert into products_views value ('S21_1234', '2022 KIA K5', 100.4, 1);
drop view products_views;

-- Bước 5
delimiter //
create procedure all_information_from_products()
begin
select * from products;
end //
delimiter ;

call all_information_from_products();

delimiter //
create procedure add__new_product(in product_code varchar(20), in product_name varchar(45), in product_price double, 
									in product_amount int, in product_description varchar(100), in product_status bit(1))
begin
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
values (product_code, product_name, product_price, product_amount, product_description, product_status);
end //
delimiter ;

call add__new_product('S30_1232', '2022 Fortuner', 100.2, 10, 'xyz', 1);

delimiter //
create procedure update_information_produce(in update_id int, in update_product_code varchar(20), in update_product_name varchar(45), in update_product_price double,
											in update_product_amount int, in update_product_description varchar(100), in update_product_status bit(1))
begin
update products
set product_code = update_product_code, product_name = update_product_name, product_price = update_product_price, product_amount = update_product_amount, 
product_description = update_product_description, product_status = update_product_status
where id = update_id;
end //
delimiter ;


set @update_id = 2, @new_product_code = 'S88_1532', @new_product_name = '2020 Xpander', @new_product_price = 233.5,
@new_product_amount = 10, @product_description = 'acb', @new_product_status = 1;
SET SQL_SAFE_UPDATES = 0;
call update_information_produce(@update_id, @new_product_code, @new_product_name, @new_product_price, @new_product_amount, @product_description, @new_product_status);
SET SQL_SAFE_UPDATES = 1;

delimiter //
create procedure delete_product(in delete_id int)
begin
delete from products
where id = delete_id;
end //
delimiter ;

call delete_product(3);