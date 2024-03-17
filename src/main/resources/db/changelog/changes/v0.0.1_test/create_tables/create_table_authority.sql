create table if not exists authority
(
    auth_id    BINARY(16) primary key,
    authority  varchar(80) not null unique,
    updated_at timestamp   not null
);