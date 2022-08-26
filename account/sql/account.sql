set names utf8;
set foreign_key_checks = 0;
drop database if exists account;
create database if not exists account;
use account;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int(100),
family_name varchar(100),
last_name varchar(100),
family_name_kana varchar(100),
last_name_kana varchar(100),
mail varchar(255),
password varchar(255),
gender int(1),
postal_code varchar(100),
prefecture varchar(100),
address_1 varchar(100),
address_2 varchar(255),
authority int(1),
delete_flg int(1),
registered_time datetime,
update_time datetime
);