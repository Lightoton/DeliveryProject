INSERT INTO roles (role_id, role_name, updated_at)
VALUES
    (UUID_TO_BIN(UUID()), 'Admin', NOW()),
    (UUID_TO_BIN(UUID()), 'User', NOW()),
    (UUID_TO_BIN(UUID()), 'Employee', NOW()),
    (UUID_TO_BIN(UUID()), 'Manager', NOW());