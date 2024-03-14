-- Вставка данных в таблицу user_role
INSERT INTO user_role (user_id, role_id)
SELECT info_id,(select role_id from roles limit 1)
FROM user_info

