# create table foods
# (
#     f_id                 BINARY(16) primary key,
#     title                varchar(80) not null unique,
#     calorie              varchar(80) not null,
#     price                double      not null,
#     finishing_cooking_at timestamp   not null,
#     created_at           timestamp   not null
# );
#
# create table foods_category
# (
#     category_id BINARY(16) primary key,
#     title       varchar(80) not null unique,
#     food_id     BINARY(16)  not null,
#     foreign key (food_id) references foods (f_id)
# );
#
#
# create table menu
# (
#     menu_id          BINARY(16) primary key,
#     title            varchar(80) not null unique,
#     average_price    double      not null,
#     created_at       timestamp   not null,
#     category_food_id BINARY(16)  not null,
#     foreign key (category_food_id) references foods_category (category_id)
# );
#
# create table restaurants
# (
#     r_id              BINARY(16) primary key,
#     title             varchar(80) not null unique,
#     address           varchar(80) not null,
#     registration_date timestamp   not null,
#     menu_id           BINARY(16)  not null,
#     foreign key (menu_id) references menu (menu_id)
# );
#
# create table user_info
# (
#     info_id      BINARY(16) primary key,
#     firstname    varchar(50) not null,
#     lastname     varchar(50) not null,
#     email        varchar(60) not null unique,
#     phone_number varchar(20) not null unique,
#     username     varchar(50) not null unique,
#     password     varchar(32) not null unique,
#     role_id      BINARY(16)  not null,
#     updated_at   timestamp   not null,
#     foreign key (role_id) references roles (role_id)
# );
#
# create table roles
# (
#     role_id      BINARY(16) primary key,
#     role_name    varchar(80) not null unique,
#     updated_at   timestamp   not null,
#     authority_id binary(16)  not null,
#     foreign key (authority_id) references authority (auth_id)
# );
#
# create table authority
# (
#     auth_id    BINARY(16) primary key,
#     authority  varchar(80) not null unique,
#     updated_at timestamp   not null,
#     role_id    BINARY(16)  not null,
#     foreign key (role_id) references roles (role_id)
# );
#
# create table clients
# (
#     u_id              BINARY(16) primary key,
#     date_of_birth     timestamp   not null,
#     rating            varchar(10) not null,
#     address           varchar(80) not null,
#     registration_date timestamp   not null,
#     user_info_id      BINARY(16)  not null,
#     foreign key (user_info_id) references user_info (info_id)
# );
#
# create table couriers
# (
#     c_id             BINARY(16) primary key,
#     rating           varchar(10) not null,
#     status_courier   varchar(60) not null default 'FREE',
#     salary           double      not null,
#     status_employee  varchar(60) not null default 'WORK',
#     hire_date        timestamp   not null,
#     termination_date timestamp,
#     user_info_id     BINARY(16)  not null,
#     foreign key (user_info_id) references user_info (info_id)
# );
#
# create table support_managers
# (
#     sm_id            BINARY(16) primary key,
#     salary           double      not null,
#     status_employee  varchar(60) not null default 'WORK',
#     hire_date        timestamp   not null,
#     termination_date timestamp,
#     user_info_id     binary(16)  not null,
#     foreign key (user_info_id) references user_info (info_id)
# );
#
# create table managers
# (
#     m_id             BINARY(16) primary key,
#     salary           double     not null,
#     hire_date        timestamp  not null,
#     termination_date timestamp,
#     user_info_id     BINARY(16) not null,
#     foreign key (user_info_id) references user_info (info_id)
# );
#
# create table orders
# (
#     o_id            BINARY(16) primary key,
#     status_order    varchar(60) not null default 'AWAITING_PAYMENT',
#     final_amount    double      not null,
#     created_at      timestamp   not null,
#     updated_at      timestamp,
#     restaurant_id   BINARY(16)  not null,
#     client_id       BINARY(16)  not null,
#     support_manager BINARY(16)  not null,
#     courier_id      BINARY(16)  not null,
#     foreign key (restaurant_id) references restaurants (r_id),
#     foreign key (client_id) references clients (u_id),
#     foreign key (support_manager) references support_managers (sm_id),
#     foreign key (courier_id) references couriers (c_id)
# );
#
# create table departments
# (
#     d_id               BINARY(16) primary key,
#     address            varchar(80),
#     created_at         timestamp,
#     updated_at         timestamp,
#     manager_id         BINARY(16),
#     support_manager_id BINARY(16),
#     courier_id         BINARY(16),
#     client_id          BINARY(16),
#     order_id           BINARY(16),
#     restaurant_id      BINARY(16),
#     foreign key (manager_id) references managers (m_id),
#     foreign key (support_manager_id) references support_managers (sm_id),
#     foreign key (courier_id) references couriers (c_id),
#     foreign key (client_id) references clients (u_id),
#     foreign key (order_id) references orders (o_id),
#     foreign key (restaurant_id) references restaurants (r_id)
# );