create table if not exists clients
(
    u_id              BINARY(16) primary key,
    date_of_birth     timestamp   not null,
    rating            varchar(10) not null,
    address           varchar(80) not null,
    registration_date timestamp   default NOW(),
    user_info_id      BINARY(16)  not null,
    department_id     BINARY(16),
    foreign key (user_info_id) references user_info (info_id)
     ON DELETE CASCADE,
    foreign key (department_id) references departments (d_id)
        ON DELETE SET NULL
);
