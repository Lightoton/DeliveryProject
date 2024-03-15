CREATE TABLE IF NOT EXISTS user_roles
(
    user_id BINARY(16) NOT NULL,
    role_id BINARY(16),
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user_info (info_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);