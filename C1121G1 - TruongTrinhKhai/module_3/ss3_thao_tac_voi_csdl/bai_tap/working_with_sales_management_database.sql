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

select * from order_detail;
insert into order_detail
values (1, 1, 3),
	   (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
