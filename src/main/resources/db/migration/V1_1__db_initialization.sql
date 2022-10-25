create table if not exists roles
(
    id           BIGSERIAL primary key,
    created_at   timestamp without time zone default now(),
    updated_at   timestamp without time zone default now(),
    name         varchar(255)
);

create table if not exists users
(
    id                 BIGSERIAL primary key,
    password           varchar(255),
    user_name          varchar(255) unique,
    created_at         timestamp without time zone default now(),
    updated_at         timestamp without time zone default now(),
    first_name         varchar(255),
    last_name          varchar(255),
    email              varchar(255),
    passport_number    varchar(255),
    status             BIGINT,
    role_id            BIGINT references roles (id) ON UPDATE CASCADE ON DELETE NO ACTION
);

insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

insert into users (password, user_name, first_name, last_name, email, passport_number, status, role_id)
values ('$2a$12$LcGFDayp0HIevCd7apA7xeO25hF9K4v1zQuHdQ3SUegQDTVbBlkV.', 'admin', 'z', 'x', 'c', 'z-x-c', 0, 1);
insert into users (password, user_name, first_name, last_name, email, passport_number, status, role_id)
values ('$2a$12$LcGFDayp0HIevCd7apA7xeO25hF9K4v1zQuHdQ3SUegQDTVbBlkV.', 'user', 'z', 'x', 'c', 'z-x-c', 0, 2);