create table if not exists foods_category
(
    category_id BINARY(16) primary key,
    title       varchar(80) not null unique,
    food_id     BINARY(16)  not null,
    created_at  timestamp   not null,
    foreign key (food_id) references foods (f_id)
);