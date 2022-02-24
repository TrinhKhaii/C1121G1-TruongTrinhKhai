use quan_ly_sinh_vien;

select * from student;

select * from student
where student_name like 'H%';

select * from class;
select * from class
where Month(start_date) = 12;

select * from `subject`;
select * from `subject`
where credit >= 3 and credit <= 5;


set SQL_SAFE_UPDATES = 0;
update student
set class_id = 2
where student_name = 'Hung';
set SQL_SAFE_UPDATES = 1;

select * from mark;
select * from subject;

select s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id join `subject` sub on m.sub_id = sub.sub_id
order by m.mark desc, s.student_name;
