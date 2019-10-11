use slktraining;

drop table if exists users;

create table users(
	id int primary key auto_increment,
	name varchar(50) not null,
	gender varchar(10) not null,
	email varchar(255) not null unique,
	phone varchar(50) not null unique,
	password varchar(255) not null,
	created_at datetime
);
