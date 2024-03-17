create table if not exists menu
(
    menu_id          BINARY(16) primary key,
    title            varchar(80) not null unique,
    average_price    double      not null,
    created_at       timestamp   not null,
    category_food_id BINARY(16)  not null,
    foreign key (category_food_id) references foods_category (category_id)
);