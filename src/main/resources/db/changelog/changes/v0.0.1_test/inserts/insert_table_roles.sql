INSERT INTO roles (role_id, role_name, updated_at)
VALUES
    (UUID_TO_BIN(UUID()), 'ROLE_ADMIN', NOW()),
    (UUID_TO_BIN(UUID()), 'ROLE_CLIENT', NOW()),
    (UUID_TO_BIN(UUID()), 'Employee', NOW()),
    (UUID_TO_BIN(UUID()), 'Manager', NOW());