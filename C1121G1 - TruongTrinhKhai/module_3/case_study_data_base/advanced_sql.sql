use furama_management;

-- 21.
create view v_nhan_vien as
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.dia_chi
from nhan_vien
inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where hop_dong.ngay_lam_hop_dong = '2020-12-08'
and nhan_vien.dia_chi like '%Gia Lai';
drop view v_nhan_vien;
select * from nhan_vien;
-- 22.
update v_nhan_vien
set nhan_vien.dia_chi = (select replace((select nhan_vien.dia_chi from nhan_vien where nhan_vien.ma_nhan_vien in 
(select nhan_vien.ma_nhan_vien from v_nhan_vien)), 'Gia Lai', 'hihi'))
where nhan_viem.ma_nhan_vien in (select v_nhan_vien.ma_nhan_vien from v_nhan_vien where v_nhan_vien.dia_chi like '%Gia Lai');



