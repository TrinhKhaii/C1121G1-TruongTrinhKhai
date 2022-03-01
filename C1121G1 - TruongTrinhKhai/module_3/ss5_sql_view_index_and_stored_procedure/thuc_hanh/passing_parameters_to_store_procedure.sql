use classicmodels;


delimiter //
create procedure get_cus_by_id(in cus_num int(11))
begin
	select * from customers where customerNumber = cus_num;
end //
delimiter ;

call get_cus_by_id(175);

delimiter //
create procedure get_customer_count_by_id(in in_city varchar(50), out total int)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
delimiter ;

call get_customer_count_by_id('Lyon', @total);
select @total;

delimiter //
create procedure set_counter(inout counter int, in inc int)
begin
    set counter = counter + inc;
end //
delimiter ;



set @counter = 1;
call set_counter(@counter, 1);
call set_counter(@counter, 1);
call set_counter(@counter, 5);
select @counter;
