create table if not exists foods
(
    f_id                 BINARY(16) primary key,
    title                varchar(80) not null unique,
    calorie              double      not null,
    price                double      not null,
    finishing_cooking_at timestamp   not null,
    created_at           timestamp   not null,
    category_id          BINARY(16)  not null ,
    foreign key (category_id) references foods_category (category_id)
);