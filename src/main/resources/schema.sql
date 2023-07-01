--create database "niffler-userdata" with owner postgres;

create extension if not exists "uuid-ossp";
create table if not exists countries
(
    id            UUID unique        not null default uuid_generate_v1() primary key,
    name   varchar(50) unique not null,
    codename      varchar(50) unique not null
);

insert into countries(name, codename) values ('Fiji', 'FJ');
insert into countries(name, codename) values ('Tanzania', 'TZ');
insert into countries(name, codename) values ('Western Sahara', 'EH');
insert into countries(name, codename) values ('Canada', 'CA');
