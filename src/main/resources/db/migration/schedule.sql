create table schedule(
    user_id int,
    day_id int
);
create table weekday(
    name text
);

create table users(
first_name text,
username text
);
        insert into days (day_name) values('Monday');
        insert into days (day_name) values('Tuesday');
        insert into days (day_name) values('Wednesday');
        insert into days (day_name) values('Thursday');
        insert into days (day_name) values('Friday');
        insert into days (day_name) values('Saturday');
        insert into days (day_name) values('Sunday');


        insert into username (firstName, id) values ('Cairo', 2);

        insert into schedule (user_id, day_id) values(1, 3);


 select * from schedule join username on username.id = user_id;
 select * from schedule join username on username.id = user_id join days on days.id = day_id;
 select * from schedule join username on username.id = user_id join days on days.id = day_id where day_id = 3;