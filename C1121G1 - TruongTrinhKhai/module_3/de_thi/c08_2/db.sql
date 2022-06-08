create database de_thi_c_08;

use de_thi_c_08;

create table medical_record(
	medical_record_id int auto_increment not null,
    medical_record_code varchar(45) not null unique,
    primary key(medical_record_id) 
);

create table patient(
	patient_id int auto_increment not null,
    patient_code varchar(45) not null unique,
    patient_name varchar(45) not null,
    start_date date not null,
    end_date date not null,
    reason varchar(45) not null,
    medical_record_code varchar(45) not null,
    primary key(patient_id),
    foreign key(medical_record_code) references medical_record(medical_record_code)
);



insert into patient(patient_code, patient_name, start_date, end_date, reason, medical_record_code) values ('BN-436', 'Nguyễn Văn A', '2016-08-07', '2019-08-08', 'Ung thư giai đoạn cuối', 'BA-001');

insert into medical_record(medical_record_code, patient_code) values ('BA-001', 'BN-435');

select * from medical_record;

select * from patient;

select medical_record.medical_record_id, medical_record.medical_record_code, patient.patient_id, patient.patient_code, patient.patient_name, patient.start_date, patient.end_date, patient.reason
from medical_record
inner join patient on medical_record.medical_record_code = patient.medical_record_code;

-- drop trigger create_trigger;
DELIMITER //
create trigger create_trigger before insert on patient
for each row
begin
insert into medical_record
set medical_record_code = new.medical_record_code;
end //
DELIMITER ;


select medical_record.medical_record_id, medical_record.medical_record_code, patient.patient_code, patient.patient_name, patient.start_date, patient.end_date, patient.reason
from medical_record
inner join patient on medical_record.medical_record_code = patient.medical_record_code
where medical_record.medical_record_code = 'BA-001';

-- Error Code: 1054. Unknown column 'new.patient.medical_record_code' in 'field list'
-- Error Code: 1054. Unknown column 'patient.medical_record_code' in 'field list'

update patient set patient_name = 'ABC', start_date = '2022-08-07', end_date = '2019-08-08', reason = 'Covid' where patient_id = 1;

