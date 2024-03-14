
create table if not exists roles
(
    role_id      BINARY(16) primary key,
    role_name    varchar(80) not null unique,
    updated_at   timestamp   not null,
    authority_id binary(16)  not null,
    foreign key (authority_id) references authority (auth_id)
);
# INSERT INTO roles (role_id, role_name, updated_at, authority_id)
# VALUES (UUID_TO_BIN(UUID()), 'Admin', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'User', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'Employee', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'Manager', NOW(), (UUID_TO_BIN(UUID())));