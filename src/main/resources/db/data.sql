insert into user_tb(username, password, email, created_at) values ('ssar', '1234', 'ssar@nate.com', now());

insert into board_tb(user_id, title, content, username, created_at) values (1, 'hello', 'vvvvvvvvv', 'ssar', now());

commit;