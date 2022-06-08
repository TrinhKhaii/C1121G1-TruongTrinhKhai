create database de_thi_c09;

use de_thi_c09;

create table product(
	product_id int auto_increment not null,
    product_name varchar(45) not null,
    product_price double not null,
    product_quantity int not null,
    product_color varchar(45) not null,
    category_id int not null,
    primary key(product_id),
    foreign key(category_id) references category(category_id)
);


create table category(
	category_id int auto_increment not null,
    category_name varchar(45) not null,
    primary key(category_id)
);

insert into category(category_name)
values ('Phone'),
	   ('Tivi'),
       ('Tủ lạnh'),
       ('Máy giặt');
       
insert into product(product_name, product_price, product_quantity, product_color, category_id)
values ('iPhone 11', 799, 12, 'Black, Yellow, Green', 1),
	   ('iPhone 11 Pro', 1100, 12, 'Black, Yellow, Green', 1);
       
select product_id, product_name, product_price, product_quantity, product_color, category.category_name
from product
inner join category on product.category_id = category.category_id
order by product.product_id;


select category_id, category_name from category;

insert into product(product_name, product_price, product_quantity, product_color, category_id) 
values ('iPhone 13', 10000, 10, 'Black', 1);


update product set product_name = 'Khai', product_price = 1000, product_quantity = 12, product_color = 'Red', category_id = 2 where product_id = 6;

delete from product where product_id = 6;

select product_id, product_name, product_price, product_quantity, product_color, category.category_name
from product
inner join category on product.category_id = category.category_id
where product_name like '%iPhone%' and product_price like '%799%' and product_color like '%Black%' and category.category_name like '%Phone%';

select product_id, product_name, product_price, product_quantity, product_color, category.category_name
from product
inner join category on product.category_id = category.category_id
where product_price like '%79%';


