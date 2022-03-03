-- Bài tập case study furama database.

-- 1.
-- create_database_furama.sql file.
use furama_management;
-- 2.
-- và có tối đa 15 kí tự.
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and (char_length(nhan_vien.ho_ten) <= 15);

-- 3.
select * from khach_hang
where round(datediff(curdate(), ngay_sinh) / 365, 0) > 18 and round(datediff(curdate(), ngay_sinh) / 365, 0) < 50
and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');

-- 4.
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach where loai_khach.ten_loai_khach = 'Diamond'
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;

-- 5.
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu,
hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
ifnull(dich_vu.chi_phi_thue, 0) + sum(ifnull(hop_dong_chi_tiet.so_luong, 0) * ifnull(dich_vu_di_kem.gia, 0)) as 'tong_tien'
from khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by hop_dong.ma_hop_dong
order by khach_hang.ma_khach_hang;

-- 6.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 1 and 3) and (year(hop_dong.ngay_lam_hop_dong) = 2021)
)
group by hop_dong.ma_dich_vu
order by dich_vu.chi_phi_thue desc;

-- 7.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where (year(hop_dong.ngay_lam_hop_dong) = 2020))
and dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (year(hop_dong.ngay_lam_hop_dong) = 2021))
group by hop_dong.ma_dich_vu;

-- 8.
-- c1:
select khach_hang.ho_ten from khach_hang
group by khach_hang.ho_ten;

-- c2:
select distinct khach_hang.ho_ten from khach_hang;

-- c3:
select khach_hang.ho_ten from khach_hang
union
select khach_hang.ho_ten from khach_hang;

-- 9.
select month(hop_dong.ngay_lam_hop_dong) as 'thang',
count(month(hop_dong.ngay_lam_hop_dong)) as 'so_luong_khach_dat_phong'
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- 10.
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc,
sum(ifnull(hop_dong_chi_tiet.so_luong, 0)) as 'so_luong_dich_vu_di_kem'
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- 11.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh' or khach_hang.dia_chi like '%Quảng Ngãi');

-- 12.
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, sum(hop_dong_chi_tiet.so_luong) as 'so_luong_dich_vu_di_kem', hop_dong.tien_dat_coc 
from hop_dong
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 10 and 12) and (year(hop_dong.ngay_lam_hop_dong) = 2020))
and dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 1 and 6) and (year(hop_dong.ngay_lam_hop_dong) = 2021))
group by hop_dong.ma_hop_dong;

-- 13.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as 'so_luong_dich_vu_di_kem'
from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all(select so_luong from hop_dong_chi_tiet);

-- 14.
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.ma_dich_vu_di_kem)
from hop_dong
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having count(dich_vu_di_kem.ma_dich_vu_di_kem) = 1
order by hop_dong.ma_hop_dong;

-- 15.
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
from nhan_vien
inner join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
inner join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <= 3;

-- 16.
-- c1:
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten from nhan_vien
where nhan_vien.ma_nhan_vien not in (select nhan_vien.ma_nhan_vien from nhan_vien
inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021
group by nhan_vien.ma_nhan_vien);

-- c2:
select nhan_vien.ma_nhan_vien from nhan_vien
where nhan_vien.ma_nhan_vien not in (select hop_dong.ma_nhan_vien from hop_dong where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021 );

-- delete:
create temporary table temp_hop_dong_xoa_nhan_vien(
select hop_dong.ma_nhan_vien from hop_dong
inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021
);

set sql_safe_updates = 0;
delete from nhan_vien where nhan_vien.ma_nhan_vien not in (select * from temp_hop_dong_xoa_nhan_vien);
set sql_safe_updates = 1;

select * from nhan_vien;

-- 17.
update khach_hang
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_loai_khach = 2
and khach_hang.ma_khach_hang in (select hop_dong.ma_khach_hang from hop_dong
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_khach_hang
having sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) > 10000000);

-- 18.
-- select
select khach_hang.ma_khach_hang, khach_hang.ho_ten
from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) < 2021;

-- delete
create temporary table temp_khach_hang(
select khach_hang.ma_khach_hang from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang where year(hop_dong.ngay_lam_hop_dong) < 2021
);

delete from hop_dong_chi_tiet where hop_dong_chi_tiet.ma_hop_dong in (select hop_dong.ma_hop_dong from hop_dong where hop_dong.ma_khach_hang in (select ma_khach_hang from temp_khach_hang));

delete from hop_dong where hop_dong.ma_khach_hang in (select ma_khach_hang from temp_khach_hang);

delete from khach_hang where khach_hang.ma_khach_hang in (select ma_khach_hang from temp_khach_hang);

select * from khach_hang;
-- 19.
create temporary table temp_gia(
select dich_vu_di_kem.ma_dich_vu_di_kem
from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where hop_dong_chi_tiet.so_luong > 10

);


set sql_safe_updates = 0;
update dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem in (select * from temp_gia);
set sql_safe_updates = 1;



-- 20.
select nhan_vien.ma_nhan_vien, nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.so_dien_thoai, nhan_vien.ngay_sinh, nhan_vien.dia_chi
from nhan_vien
union
select khach_hang.ma_khach_hang, khach_hang.ma_khach_hang, khach_hang.ho_ten, khach_hang.email, khach_hang.so_dien_thoai, khach_hang.ngay_sinh, khach_hang.dia_chi
from khach_hang;

