use slktraining;

drop table if exists messages;
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

insert into users values
(null, 'Vinod Kumar', 'vinod@vinod.co', '9731424784', 'Male', md5('secret'), sysdate()),
(null, 'Shyam Sundar', 'shyamkc@example.com', '9731401234', 'Male', md5('secret'), sysdate()),
(null, 'John Doe', 'johndoe@example.com', '9731424111', 'Male', md5('secret'), sysdate()),
(null, 'Jane Doe', 'janedoe@example.com', '9731424222', 'Female', md5('secret'), sysdate());

create table messages(
	id int primary key auto_increment,
	msg_from varchar(255) not null,
	msg_to varchar(255) not null,
	msg_cc varchar(255),
	msg_subject varchar(255),
	msg_body text,
	sent_at datetime
);

insert into messages values
(null, 'shyamkc@example.com', 'vinod@vinod.co', null, 'Hello', 'Hello Vinod', sysdate()),
(null, 'shyamkc@example.com', 'johndoe@example.com', 'vinod@vinod.co', 'Hello John', 'Hello John', sysdate()),
(null, 'shyamkc@example.com', 'vinod@vinod.co', 'johndoe@example.com', 'Status of our project', 'Hi Vinod, can you please update the status of our project? - Shyam', sysdate()),
(null, 'shyamkc@example.com', 'vinod@vinod.co', null, 'Bug found', 'Hey Vinod, I found a bug in your code. Call me when possible. - Shyam', sysdate());




