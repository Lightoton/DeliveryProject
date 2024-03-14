
create table if not exists authority
(
    auth_id    BINARY(16) primary key,
    authority  varchar(80) not null unique,
    updated_at timestamp   not null,
    role_id    BINARY(16)
#     foreign key (role_id) references roles (role_id)
);
# INSERT INTO authority (auth_id, authority, updated_at, role_id)
# VALUES (UUID_TO_BIN(UUID()), 'Admin Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
#        (UUID_TO_BIN(UUID()), 'Employee Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
#        (UUID_TO_BIN(UUID()), 'Manager Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Manager')),
#        (UUID_TO_BIN(UUID()), 'User access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'User'));