-- db casestudy module 3
-- create tables

-- drop database case_study_module_3_db;

create database case_study_module_3_db;

use case_study_module_3_db;

create table `position`(
	position_id   int         auto_increment not null,
    position_name varchar(45),
    primary key(position_id)
);

create table education_degree(
	education_degree_id  int         auto_increment not null,
    education_degree_name varchar(45),
    primary key(education_degree_id)
);

create table division(
	division_id  int         auto_increment not null,
    division_name varchar(45),
    primary key(division_id)
);

create table `role`(
	role_id int auto_increment not null,
    role_name varchar(255),
    primary key(role_id)
);

create table `user`(
	user_name varchar(255) not null,
    password varchar(255),
    primary key(user_name)
);

create table user_role(
	role_id int auto_increment not null,
    user_name varchar(255),
    foreign key(role_id) references `role`(role_id),
    foreign key(user_name) references `user`(user_name),
    primary key(role_id, user_name)
);

create table employee(
	employee_id  int         auto_increment not null,
    employee_name        varchar(45) not null,
    employee_birthday     date        not null,
    employee_id_card       varchar(45) not null,
    employee_salary         double      not null,
    employee_phone varchar(45) not null,
    employee_email         varchar(45),
    employee_address       varchar(45),
    primary key(employee_id),
    position_id     int         not null,
    education_degree_id   int         not null,
    division_id    int         not null,
    user_name varchar(255),
    foreign key(position_id)   references `position`(position_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(division_id)  references division(division_id),
    foreign key(user_name) references `user`(user_name)
);

create table customer_type(
	customer_type_id  int         auto_increment not null,
    customer_type_name varchar(45),
    primary key(customer_type_id)
);

create table customer(
	customer_id int auto_increment not null,
    customer_code varchar(45) not null,
	customer_type_id int not null,
    customer_name        varchar(45) not null,
    customer_birthday     date        not null,
    customer_gender     bit(1)      not null,
    customer_id_card       varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email         varchar(45),
    customer_address       varchar(45),
    primary key(customer_id),
    foreign key(customer_type_id) references customer_type(customer_type_id),
    unique(customer_code)
);

create table rent_type(
	rent_type_id  int         auto_increment not null,
    rent_type_name varchar(45),
    rent_type_cost double,
    primary key(rent_type_id)
);

create table service_type(
	service_type_id int auto_increment not null,
	service_type_name varchar(45),
    primary key(service_type_id)
);

create table service(
	service_id 			 int 		 auto_increment not null,
    service_code varchar(45) not null,
    service_name 		 varchar(45) not null,
    service_area 			 int,
    service_cost 		 double 	 not null,
    service_max_people 	 int,
    standard_room     varchar(45),
    description_other_convenience varchar(45),
    pool_area     double,
    number_of_floors              int,
    free_service_included varchar(45),
    rent_type_id         int 		 not null,
    service_type_id      int         not null,
    primary key(service_id),
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);

create table attach_service(
	attach_service_id  int         auto_increment not null,
    attach_service_name varchar(45) not null,
    attach_service_cost                double      not null,
    attach_service_unit             varchar(10) not null,
    attach_service_status         varchar(45),
    primary key(attach_service_id)
);

create table contract(
	contract_id       int      auto_increment not null,
    contract_start_date datetime not null,
    contract_end_date     datetime not null,
    contract_deposit      double   not null,
    contract_total_money double not null,
	employee_id     int      not null,
    customer_id     int      not null,
    service_id        int      not null,
    primary key(contract_id),
    foreign key(employee_id)  references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id)    references service(service_id)
);

create table contract_detail(
	contract_detail_id int auto_increment not null,
    quantity             int not null,
    contract_id          int not null,
    attach_service_id    int not null,
    primary key(contract_detail_id),
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);

-- add datas to tables
use case_study_module_3_db;

insert into `position`(position_name)
values ('Nhân viên'),
       ('Lễ tân'),
       ('Phục vụ'),
       ('Chuyên viên'),
       ('Giám sát'),
       ('Quản lý'),
       ('Giám đốc');
       
insert into education_degree(education_degree_name)
values ('Trung Cấp'),
	   ('Cao Đẳng'),
	   ('Đại học'),
       ('Sau Đại học');

insert into division(division_name)
values ('Sale-Marketing'),
	   ('Hành chính'),
       ('Phục vụ'),
       ('Quản lý');
       
insert into role(role_name)
values ('Admin'),
	   ('Nhân viên');
       
insert into user(user_name, password)
values ('annguyen', '123'),
	   ('binhlv', '123'),
       ('thiyen', '123'),
       ('toan0404', '123'),
       ('phatphat', '123'),
       ('annghi20', '123'),
       ('nhh0101', '123'),
       ('donghanguyen', '123'),
       ('hoangtong', '123'),
       ('nguyencongdao12', '123');
--        
insert into user(user_name, password)
values ('khaihihi', '123');
       
insert into user_role(role_id, user_name)
values (1, 'annguyen'),
	   (2, 'binhlv'),
       (2, 'thiyen'),
       (2, 'toan0404'),
       (2, 'phatphat'),
       (2, 'annghi20'),
       (2, 'nhh0101'),
       (2, 'donghanguyen'),
       (2, 'hoangtong'),
       (2, 'nguyencongdao12');
       
insert into user_role(role_id, user_name)
values (1, 'khaihihi');
       
       
insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, user_name)
values ('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1, 'annguyen'),
	   ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2, 'binhlv'),
       ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, 'thiyen'),
       ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, 'toan0404'),
       ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1, 'phatphat'),
       ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, 'annghi20'),
       ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, 'nhh0101'),
       ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111','donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4, 'donghanguyen'),
       ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, 'hoangtong'),
       ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2, 'nguyencongdao12');

insert into customer_type(customer_type_name)
values ('Diamond'),
	   ('Platium'),
       ('Gold'),
       ('Silver'),
       ('Member');
       
insert into customer(customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)
values ('KH-1111', 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
	   ('KH-2222', 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
       ('KH-3333', 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
       ('KH-4444', 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
       ('KH-5555', 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
       ('KH-6666', 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
       ('KH-7777', 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
       ('KH-8888', 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
       ('KH-9999', 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
       ('KH-1010', 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng',2);
       
insert into rent_type(rent_type_name)
values ('year'),
	   ('month'),
       ('day'),
       ('hour');
       
insert into service_type(service_type_name)
values ('Villa'),
	   ('House'),
       ('Room');

insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id)
values ('DV-1111', 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi', 500, 4, 3, 1);
insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, number_of_floors, rent_type_id, service_type_id)
values ('DV-2222', 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', 3, 2, 2);
insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, rent_type_id, service_type_id, free_service_included)
values ('DV-3333', 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', 4, 3, 'Tay vịn');
insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id)
values ('DV-4444', 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, 3, 1);
insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, number_of_floors, rent_type_id, service_type_id)
values ('DV-5555', 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', 2, 3, 2);
insert into service(service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, rent_type_id, service_type_id, free_service_included)
values ('DV-6666', 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', 4, 3, 'Mát xa');

insert into attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện đại'),
	   ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
       ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
       ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

insert into contract(contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values ('2020-12-08', '2020-12-08', 0, 1000000, 3, 1, 3),
	   ('2020-07-14', '2020-07-21', 200000, 1000000, 7, 3, 1),
       ('2021-03-15', '2021-03-17', 50000, 1000000, 3, 4, 2),
       ('2021-01-14', '2021-01-18', 100000, 1000000, 7, 5, 5),
       ('2021-07-14', '2021-07-15', 0, 1000000, 7, 2, 6),
       ('2021-06-01', '2021-06-03', 0, 1000000, 7, 7, 6),
       ('2021-09-02', '2021-09-05', 100000, 1000000, 7, 4, 4),
       ('2021-06-17', '2021-06-18', 150000, 1000000, 3, 4, 1),
       ('2020-11-19', '2020-11-19', 0, 1000000, 3, 4, 3),
       ('2021-04-12', '2021-04-14', 0, 1000000, 10, 3, 5),
       ('2021-04-25', '2021-04-25', 0, 1000000, 2, 2, 1),
       ('2021-05-25', '2021-05-27', 0, 1000000, 7, 10, 1);
       
insert into contract_detail(quantity, contract_id, attach_service_id)
values (5, 2, 4),
	   (8, 2, 5),
       (15, 2, 6),
       (1, 3, 1),
       (11, 3, 2),
       (1, 1, 3),
       (2, 1, 2),
       (2, 12, 2);
       
      --  Error Code: 1364. Field 'contract_total_money' doesn't have a default value
