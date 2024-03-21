create table if not exists menu
(
    menu_id          BINARY(16) primary key,
    title            varchar(80) not null unique,
    average_price    double      not null,
    created_at       timestamp   not null,
    restaurant_id    BINARY(16)  not null,
    foreign key (restaurant_id) references restaurants (r_id)
);