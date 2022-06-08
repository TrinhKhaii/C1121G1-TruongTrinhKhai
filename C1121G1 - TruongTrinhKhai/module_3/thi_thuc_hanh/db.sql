create database thi_thuc_hanh;

use thi_thuc_hanh;


create table book(
	book_id varchar(50) not null,
    book_name varchar(50) not null,
    author varchar(50) not null,
    `description` varchar(50) not null,
    amount int not null,
    primary key(book_id)
);

create table student(
	student_id int auto_increment not null,
    student_name varchar(50) not null,
    student_class_name varchar(50) not null,
    primary key(student_id)
);

create table library_card(
	library_card_id varchar(50) not null,
    book_id varchar(50) not null,
    student_id int not null,
    start_date date not null,
    end_date date not null,
    primary key(library_card_id),
    foreign key(book_id) references book(book_id),
    foreign key(student_id) references student(student_id)
);



insert into book(book_id, book_name, author, `description`, amount)
values ('S-001', 'Số đỏ', 'Vũ Trọng Phụng', 'Nhân vật chính là Xuân tóc đỏ và ...', 10),
('S-002', 'Truyện Kiều', 'Nguyễn Du', 'cuộc đời Thúy Kiều ...', 15);

-- insert into sach(id_sach, ten_sach, tac_gia, mo_ta, so_luong, trang_thai)
-- values ('S-003', 'Codegym', 'Trần Văn Chánh', 'hihi ... ', 20, false);

insert into student(student_name, student_class_name)
values ('Trương Trịnh Khải', "C1121G1"),
("Đoàn Ngọc Lĩnh", "C1121G1");

insert into library_card(library_card_id, book_id, student_id, start_date, end_date)
values ('MS-0001', 'S-001', 1, '2022-03-03', '2022-03-05');

select * from book;
select * from student;
select * from library_card;


DELIMITER //
create trigger borrow_book_trigger before insert on library_cardvvv
for each row
begin
insert into medical_record
set medical_record_code = new.medical_record_code;
end //
DELIMITER ;


select library_card_id, book.book_name, book.author, student.student_name, student.student_class_name, start_date, end_date
from library_card
inner join book on library_card.book_id = book.book_id
inner join student on library_card.student_id = student.student_id;

select * from book where book_id = 'S-001';

select * from student where student_id = 1;