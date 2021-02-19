# WaiterApp-Java



```java

interface dao.Person {
    String fName, lName, username, id, email, password;
    List<dao.Day> days;
}


interface dao.Day {
    String day;
    List<dao.Person> waiters;
}


interface dao.Schedule {
    List<waiter.days.Days> weekday;

}


```


```roomsql

create table schedule(
    user_id int,
    day_id int
);
```

> weekdays


```roomsql

create table weekday(
    name text
)

```

```roomsql
create table users(
first_name text,
username text
)
```