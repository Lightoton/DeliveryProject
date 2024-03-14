
INSERT INTO authority (auth_id, authority, updated_at, role_id)
VALUES (UUID_TO_BIN(UUID()), 'Admin Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
       (UUID_TO_BIN(UUID()), 'Employee Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
       (UUID_TO_BIN(UUID()), 'Manager Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Manager')),
       (UUID_TO_BIN(UUID()), 'User access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'User'));