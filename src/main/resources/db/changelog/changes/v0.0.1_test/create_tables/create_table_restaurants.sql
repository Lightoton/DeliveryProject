create table if not exists restaurants
(
    r_id              BINARY(16) primary key,
    title             varchar(80) not null unique,
    address           varchar(80) not null,
    registration_date timestamp   not null,
    department_id     BINARY(16),
    foreign key (department_id) references departments (d_id)
);