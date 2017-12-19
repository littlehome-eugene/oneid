drop table if exists user;

create table user (
        user_id varchar(256) primary key,
        hash varchar(256),
        password varchar(256),
        hkey varchar(256)

) ENGINE=InnoDB;


insert into user (user_id, password) values ('test', '1234');