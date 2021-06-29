
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