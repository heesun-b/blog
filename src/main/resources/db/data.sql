insert into user_tb(username, password, email, created_at) values ('ssar', '1234', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at) values ('love', '1234', 'love@nate.com', now());

insert into board_tb(user_id, title, content, username, created_at) values (1, '제목1', '111111111', 'ssar', now());
insert into board_tb(user_id, title, content, username, created_at) values (1, '제목2', '222222222', 'ssar', now());
insert into board_tb(user_id, title, content, username, created_at) values (2, '제목3', '333333333', 'cos', now());
insert into board_tb(user_id, title, content, username, created_at) values (1, '제목4', '44444444444', 'ssar', now());
insert into board_tb(user_id, title, content, username, created_at) values (2, '제목5', '555555555', 'cos', now());
insert into board_tb(user_id, title, content, username, created_at) values (2, '제목6', '66666666666', 'cos', now());

commit;