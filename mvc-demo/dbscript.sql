use slktraining;

drop table if exists users;

create table users (
    id int primary key auto_increment,
    name varchar(50) not null,
    email varchar(255) not null unique,
    phone varchar(50) not null unique,
    gender varchar(10) not null,
    password varchar(255) not null,
    created_at datetime
);

insert into users values(null, 'Vinod', 'vinod@vinod.co', '9731424784', 'Male', 'd2c51c9cde1f15b718296c99ae362fb1', sysdate());
