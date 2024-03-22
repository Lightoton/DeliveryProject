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