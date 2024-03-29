create table if not exists restaurants
(
    r_id              BINARY(16) primary key,
    title             varchar(80) not null unique,
    address           varchar(80) not null,
    registration_date timestamp   not null,
    menu_id           BINARY(16)  not null,
    foreign key (menu_id) references menu (menu_id)
);