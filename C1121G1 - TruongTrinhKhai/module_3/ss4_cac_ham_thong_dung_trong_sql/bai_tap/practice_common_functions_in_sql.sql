use quan_ly_sinh_vien;

select * from mark;
select * from subject;

select * 
from `subject` 
where credit >= all(select credit from `subject`);

select mark.mark_id, mark.mark, subject.sub_name, subject.credit, `subject`.`status`
from mark join `subject` on mark.sub_id = `subject`.sub_id
group by mark.mark_id
having mark.mark >= all(select max(mark) from mark);

select * from student;

select *, avg(mark.mark)
from student join mark on student.student_id = mark.student_id
group by student.student_id
order by avg(mark.mark) desc;

