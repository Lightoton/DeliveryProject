
create table if not exists user_info
(
    info_id      binary(16) primary key,
    firstname    varchar(50) not null,
    lastname     varchar(50) not null,
    email        varchar(60) not null unique,
    phone_number varchar(20) not null unique,
    username     varchar(50) not null unique,
    password     varchar(32) not null unique,
    updated_at   timestamp   not null
);
create table if not exists managers
(
    m_id             BINARY(16) primary key,
    salary           double     not null,
    hire_date        timestamp  not null,
    termination_date timestamp,
    user_info_id     BINARY(16) not null,
    foreign key (user_info_id) references user_info (info_id)
);
create table if not exists departments
(
    d_id       BINARY(16) primary key,
    address    varchar(80),
    created_at timestamp,
    updated_at timestamp,
    manager_id BINARY(16),
    foreign key (manager_id) references managers (m_id)
);
create table if not exists restaurants
(
    r_id              BINARY(16) primary key,
    title             varchar(80) not null unique,
    address           varchar(80) not null,
    registration_date timestamp   not null,
    department_id     BINARY(16),
    foreign key (department_id) references departments (d_id)
);
create table if not exists menu
(
    menu_id       BINARY(16) primary key,
    title         varchar(80) not null unique,
    average_price double      not null,
    created_at    timestamp   not null,
    restaurant_id BINARY(16)  not null,
    foreign key (restaurant_id) references restaurants (r_id)
);
create table if not exists foods_category
(
    category_id BINARY(16) primary key,
    title       varchar(80) not null unique,
    created_at  timestamp   not null,
    menu_id     binary(16)  not null,
    foreign key (menu_id) references menu (menu_id)
);
create table if not exists foods
(
    f_id                 BINARY(16) primary key,
    title                varchar(80) not null unique,
    calorie              double      not null,
    price                double      not null,
    finishing_cooking_at timestamp   not null,
    created_at           timestamp   not null,
    category_id          BINARY(16)  not null,
    foreign key (category_id) references foods_category (category_id)
);
create table if not exists authority
(
    auth_id    BINARY(16) primary key,
    authority  varchar(80) not null unique,
    updated_at timestamp   not null
);
create table if not exists roles
(
    role_id    BINARY(16) primary key,
    role_name  varchar(80) not null unique,
    updated_at timestamp   not null
);
CREATE TABLE if not exists role_authority
(
    role_id      BINARY(16) NOT NULL,
    authority_id BINARY(16) NOT NULL,
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
    FOREIGN KEY (authority_id) REFERENCES authority (auth_id)
);
CREATE TABLE IF NOT EXISTS user_roles
(
    user_info_id BINARY(16) NOT NULL,
    role_id      BINARY(16),
    PRIMARY KEY (user_info_id, role_id),
    FOREIGN KEY (user_info_id) REFERENCES user_info (info_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);
create table if not exists clients
(
    u_id              BINARY(16) primary key,
    date_of_birth     timestamp   not null,
    rating            varchar(10) not null,
    address           varchar(80) not null,
    registration_date timestamp   not null,
    user_info_id      BINARY(16)  not null,
    department_id     BINARY(16),
    foreign key (user_info_id) references user_info (info_id),
    foreign key (department_id) references departments (d_id)
);
create table if not exists support_managers
(
    sm_id            BINARY(16) primary key,
    salary           double      not null,
    status_employee  varchar(60) not null default 'WORK',
    hire_date        timestamp   not null,
    termination_date timestamp,
    user_info_id     binary(16)  not null,
    department_id    BINARY(16),
    foreign key (user_info_id) references user_info (info_id),
    foreign key (department_id) references departments (d_id)
);
create table if not exists orders
(
    o_id          BINARY(16) primary key,
    status_order  varchar(60) not null default 'AWAITING_PAYMENT',
    final_amount  double      not null,
    created_at    timestamp   not null,
    updated_at    timestamp,
    restaurant_id BINARY(16)  not null,
    client_id     BINARY(16)  not null,
    sm_id         BINARY(16)  not null,
    department_id BINARY(16)  not null,
    foreign key (restaurant_id) references restaurants (r_id),
    foreign key (client_id) references clients (u_id),
    foreign key (sm_id) references support_managers (sm_id),
    foreign key (department_id) references departments (d_id)
);
create table if not exists couriers
(
    c_id             BINARY(16) primary key,
    rating           varchar(10) not null,
    status_courier   varchar(60) not null default 'FREE',
    salary           double      not null,
    status_employee  varchar(60) not null default 'WORK',
    hire_date        timestamp   not null,
    termination_date timestamp,
    user_info_id     BINARY(16)  not null,
    order_id         BINARY(16),
    department_id    BINARY(16),
    foreign key (user_info_id) references user_info (info_id),
    foreign key (order_id) references orders (o_id),
    foreign key (department_id) references departments (d_id)
);
