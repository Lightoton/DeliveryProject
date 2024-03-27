CREATE TABLE if not exists role_authority
(
    role_id      BINARY(16) NOT NULL,
    authority_id BINARY(16) NOT NULL,
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
        ON DELETE CASCADE,
    FOREIGN KEY (authority_id) REFERENCES authority (auth_id)
        ON DELETE CASCADE
);