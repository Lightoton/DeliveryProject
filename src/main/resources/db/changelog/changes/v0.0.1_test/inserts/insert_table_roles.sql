

INSERT INTO roles (role_id, role_name, updated_at, authority_id)
VALUES (UUID_TO_BIN(UUID()), 'Admin', NOW(), (select auth_id from authority where authority= 'Admin Access')),
       (UUID_TO_BIN(UUID()), 'User', NOW(), (select auth_id from authority where authority='User access')),
       (UUID_TO_BIN(UUID()), 'Employee', NOW(), (select auth_id from authority where authority='Employee Access')),
       (UUID_TO_BIN(UUID()), 'Manager', NOW(), (select auth_id from authority where authority='Manager Access'));