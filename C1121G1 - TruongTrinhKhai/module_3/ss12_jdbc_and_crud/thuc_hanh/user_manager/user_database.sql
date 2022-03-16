create database demo_user_manager;

use demo_user_manager;

create table users (
	id 		int(3) 		 not null auto_increment,
    name 	varchar(120) not null,
    email 	varchar(220) not null,
    country varchar(120),
    primary key(id)
);


insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users;

delimiter //
create procedure get_user_by_id(in user_id int) 
begin
	select users.name, users.email, users.country
    from users
    where users.id = user_id;
end //
delimiter ;

delimiter //
create procedure insert_user (in user_name varchar(50), in user_email varchar(50), in user_country varchar(50))
begin 
	insert into users(`name`, email, country) values (user_name, user_email, user_country);
end //
delimiter ;

create table Permision(
	id int(11),
    name varchar(50),
    primary key(id)
);

create table User_Permision(
	permision_id int(11),
    user_id int(11)
);

insert into Permision(id, name) values(1, 'add'), 
									  (2, 'edit'),
                                      (3, 'delete'),
                                      (4, 'view');

select * from employee;
select * from Permision;
select * from users;
select * from User_Permision;

delimiter //
create procedure get_all_users()
begin
	select * from users;
end //
delimiter ;

call get_all_users();

delimiter //
create procedure update_user(in id int, in name varchar(120), in email varchar(120), in country varchar(120))
begin
	update users
    set users.name = name, users.email = email, users.country = country
    where users.id = id;
end //
delimiter ;

delimiter //
create procedure delete_user(in id int)
begin
	delete from users
    where users.id = id;
end //
delimiter ;





