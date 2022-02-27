use sales_manager;

select * from customer;

insert into customer(c_name, c_age)
values ('Minh Quan', 10),
	   ('Ngoc Oanh', 20),
       ('Hong Ha', 50);
	


insert into `order`(c_id, o_date)
values (1, '2006-03-21'),
	   (2, '2006-03-23'),
       (1, '2006-03-16');
       
select * from product;
insert into product (p_name, p_price)
values ('May giat', 3),
	   ('Tu Lanh', 5),
       ('Dieu hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);

select * from order_detail;
insert into order_detail(o_id, p_id, od_qty)
values (1, 1, 3),
	   (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
       
       
select o_id, o_date, o_total_price from `order`;

select customer.c_name, product.p_name from product
inner join order_detail on product.p_id = order_detail.p_id
inner join `order` on order_detail.o_id = `order`.o_id
inner join customer on `order`.c_id = customer.c_id;

select c_name as 'customer not buy anything' from customer
where customer.c_id not in (select c_id from `order`);

select `order`.o_id, o_date, sum(product.p_price * order_detail.od_qty) as total_price from `order`
inner join order_detail on `order`.o_id = order_detail.o_id
inner join product on order_detail.p_id = product.p_id
group by `order`.o_id;

select `order`.o_id, o_date, product.p_name, order_detail.od_qty, sum(product.p_price * order_detail.od_qty) as total from `order`
inner join order_detail on `order`.o_id = order_detail.o_id
inner join product on order_detail.p_id = product.p_id
group by product.p_id;

SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
