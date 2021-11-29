INSERT INTO COMMENTS(id, user_Name, message, comment_Date)
VALUES ('c9fedec4-7b34-45d6-93bd-82452a4ebdef', 'userName1', 'message1', '18-11-2021 10:29'),
       ('4fae1012-319c-4e89-b08d-5f886815e402', 'userName2', 'message2', '19-11-2021 11:35'),
       ('631b07a5-29b5-41ba-95fc-cf48dfc777ad', 'userName3', 'message3', '20-11-2021 20:35'),
       ('8805f791-b138-4479-b882-fbf48c17d363','userName4', 'message4', '21-11-2021 21:37'),
       ('cf6a5749-91d6-4ecc-8e0e-9a0431a35a79','userName4', 'message4', '23-11-2021 22:38');
INSERT INTO USERS(id, username, name, surname, country, city, street, zip_code, phone, password) VALUES
        ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', 'user', 'Useriukas', 'Useriauskas', 'Lithuania', 'Vilniaus', 'Savanoriu', '572441', '867489665', '{bcrypt}$2a$10$jYIbAef1H7S.womsk7MRtOCSEx/DgM7CZ1nNeLLzoZ/OPs0a25DV2'), /*pass->user*/
        ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', 'admin', 'Adminas', 'Adminiauskas', 'Lithuania', 'Kaunas', 'Savanoriu', '572441', '867489665','{bcrypt}$2a$10$VylYhXDaKC7W28tQTvYYkOdZIj2pnPVIobXOConbXy3xeBcF6Xuni'); /*pass->user*/
-- INSERT INTO ROLES(id, name) VALUES
--         ('60dbb7bb-99a0-42eb-a837-8be6b697c074', 'USER'),
--         ('3906c549-44bf-494b-9537-5e1658a029a8', 'ADMIN');
-- INSERT INTO USERS_ROLES(user_id, roles_id) VALUES
--         ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
--         ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
--         ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '3906c549-44bf-494b-9537-5e1658a029a8');