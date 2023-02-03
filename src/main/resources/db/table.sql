create table user_tb (
    id int auto_increment primary key, 
    username varchar not null unique,
    password varchar not null,
    email varchar not null unique, 
    created_at timestamp not null
);

create table board_tb (
    id int auto_increment primary key,
    user_id int, 
    username varchar not null,
    title varchar(30) not null,
    content text not null,
    created_at timestamp not null
); 

commit;