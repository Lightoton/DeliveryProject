create table if not exists foods
(
    f_id                 BINARY(16) primary key,
    title                varchar(80) not null unique,
    calorie              varchar(80) not null,
    price                double      not null,
    finishing_cooking_at timestamp   not null,
    created_at           timestamp   not null
);