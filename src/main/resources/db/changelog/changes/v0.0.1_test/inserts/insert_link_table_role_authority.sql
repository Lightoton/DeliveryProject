-- Вставка данных в таблицу role_authority
INSERT INTO role_authority (role_id, authority_id)
SELECT roles.role_id, authority.auth_id
FROM roles
         JOIN authority ON roles.role_name = SUBSTRING_INDEX(authority.authority, ' ', -1);