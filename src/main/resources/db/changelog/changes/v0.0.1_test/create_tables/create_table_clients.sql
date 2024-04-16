create table if not exists clients
(
    u_id              BINARY(16) primary key,
    date_of_birth     date,
    rating            varchar(10) default 'STAR10',
    address           varchar(80) not null,
    registration_date timestamp   default now(),
    user_info_id      BINARY(16)  not null,
    department_id     BINARY(16),
    foreign key (user_info_id) references user_info (info_id)
     ON DELETE CASCADE,
    foreign key (department_id) references departments (d_id)
        ON DELETE SET NULL
);
