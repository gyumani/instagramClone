create database if not exists insta;
use insta;

drop table profile;
drop table if exists user;
drop table if exists feed;
drop table if exists comment


create table user(
                     id integer not null auto_increment primary key,
                     username varchar(100) not null,
                     password varchar(100) not null,
                     email varchar(100) not null,
                     firstName varchar(40) not null,
                     lastName varchar(40) not null,
                     role varchar(20) not null,
                     bio longtext,
                     picture varchar(100),
                     website varchar(100),
                     createDate date not null
);

create table feed(
                     id integer not null auto_increment primary key,
                     username varchar(100) not null,
                     picture varchar(100) not null,
                     content longtext,
                     createDate date not null,
                     updateDate date not null
);

create table comment(
                    id integer not null auto_increment primary key,
                    post_id integer not null,
                    username varchar (100) not null,
                    content varchar (100) not null,
                    createDate date not null
                    foreign key post_id references feed(id)
);