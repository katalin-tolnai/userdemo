drop table if exists user;

create  table user(
                      ID int not null ,
                      FIRST_NAME varchar(150) not null,
                      LAST_NAME varchar(100) not null,
                      BIRTH_DATE date not null,
                      PRIMARY KEY ( ID )
);