create table if not exists roles
(
    role_id      BINARY(16) primary key,
    role_name    varchar(80) not null unique,
    updated_at   timestamp   default NOW()
);