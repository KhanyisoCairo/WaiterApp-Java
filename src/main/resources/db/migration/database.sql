drop table if exists waiters, days, shifts;

CREATE TABLE  waiters(
    id serial primary key,
    username text
);

CREATE TABLE days(
    id  serial primary key,
    name text
);

CREATE TABLE shifts(
    id serial primary key,
    waiter_id INT REFERENCES waiters(id),
    day_id INT REFERENCES days(id)
);


insert into days (name) values('Sunday');
insert into days (name) values('Monday');
insert into days (name) values('Tuesday');
insert into days (name) values('Wednesday');
insert into days (name) values('Thursday');
insert into days (name) values('Friday');
insert into days (name) values('Saturday');

