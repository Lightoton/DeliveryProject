create table if not exists user_info
(
    info_id      BINARY(16) primary key,
    firstname    varchar(50) not null,
    lastname     varchar(50) not null,
    email        varchar(60) not null unique,
    phone_number varchar(20) not null unique,
    username     varchar(50) not null unique,
    password     varchar(32) not null unique,
    updated_at   timestamp   not null
);