create table if not exists foods_category
(
    category_id BINARY(16) primary key,
    title       varchar(80) not null unique,
    created_at  timestamp   not null,
    menu_id     binary(16)  not null,
    foreign key (menu_id) references menu (menu_id)
);