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
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as tong_tien
from khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
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
select month(hop_dong.ngay_lam_hop_dong) as thang, count(hop_dong.ma_khach_hang) as so_luong_khach_hang
from hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) = 2021
group by hop_dong.ma_khach_hang
order by month(hop_dong.ngay_lam_hop_dong);

