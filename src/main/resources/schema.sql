drop table if exists user;

create table user
(
    ID         varchar(150) not null,
    FIRST_NAME varchar(150) not null,
    LAST_NAME  varchar(100) not null,
    BIRTH_DATE date         not null,
    PRIMARY KEY (ID)
);

create table adress
(
    ID           varchar(150) not null,
    CITY         varchar(150) not null,
    STREET         varchar(150) not null,
    HOUSE_NR     varchar(10)  not null,
    APARTMENT_NR varchar(10),
    ZIP_CODE     int          not null,
    PRIMARY KEY (ID)
)