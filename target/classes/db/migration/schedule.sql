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
        insert into days (days_in_a_week) values('Monday');
        insert into days (days_in_a_week) values('Tuesday');
        insert into days (days_in_a_week) values('Wednesday');
        insert into days (days_in_a_week) values('Thursday');
        insert into days (days_in_a_week) values('Friday');
        insert into days (days_in_a_week) values('Saturday');
        insert into days (days_in_a_week) values('Sunday');


        insert into username (name, counter) values ('Cairo', 2);

        insert into schedule (user_id, day_id) values(1, 3);


 select * from schedule join username on username.id = user_id;
 select * from schedule join username on username.id = user_id join days on days.id = day_id;
 select * from schedule join username on username.id = user_id join days on days.id = day_id where day_id = 3;