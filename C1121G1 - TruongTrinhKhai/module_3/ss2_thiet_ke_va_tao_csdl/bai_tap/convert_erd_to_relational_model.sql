create database product_management;

use product_management;

create table nha_cung_cap(
	ma_ncc int auto_increment,
    ten_ncc varchar(50),
    dia_chi varchar(50),
    primary key(ma_ncc)
);

create table sdt(
	ma_sdt int auto_increment,
    sdt varchar(11),
    ma_ncc int,
    primary key(ma_sdt),
    foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);

create table don_dh(
	so_don_dh int auto_increment,
    ngay_dh date,
    ma_ncc int,
    primary key(so_don_dh),
    foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);

create table vat_tu(
	ma_vtu int auto_increment,
    ten_vtu varchar(50),
    primary key(ma_vtu)
);

create table don_dh_cua_vat_tu(
	ma_vtu int,
    so_don_dh int,
    primary key(ma_vtu, so_don_dh),
    foreign key(ma_vtu) references vat_tu(ma_vtu),
    foreign key(so_don_dh) references don_dh(so_don_dh)
);

create table phieu_xuat(
	so_px int auto_increment,
    ngay_xuat date,
    primary key(so_px)
);

create table phieu_xuat_cua_vat_tu(
	so_px int,
    ma_vtu int,
    dg_xuat float,
    sl_xuat int,
    primary key(so_px, ma_vtu),
    foreign key(so_px) references phieu_xuat(so_px),
    foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table phieu_nhap(
	so_pn int auto_increment,
    ngay_nhap date,
    primary key(so_pn)
);

create table phieu_nhap_cua_vat_tu(
	so_pn int,
    ma_vtu int,
    dg_nhap float,
    sl_nhap int,
    primary key(so_pn, ma_vtu),
    foreign key(so_pn) references phieu_nhap(so_pn),
    foreign key(ma_vtu) references vat_tu(ma_vtu)
);
