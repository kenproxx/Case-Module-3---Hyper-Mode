INSERT INTO playerdou.role (id, role_name, status, create_date, update_date) VALUES (1, 'User', 0, '2022-05-27 10:12:01', '2022-05-27 10:13:01');
INSERT INTO playerdou.role (id, role_name, status, create_date, update_date) VALUES (2, 'Admin', 1, '2022-05-27 10:13:01', '2022-05-27 10:13:03');
DELETE FROM `playerdou`.`role` WHERE (`id` = '1');

DELETE FROM `playerdou`.`role` WHERE (`id` = '2');
DELETE FROM `playerdou`.`role` WHERE (`id` = '1');