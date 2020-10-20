# WaiterApp-Java



```java

interface Person {
    String fName, lName, username, id, email, password;
    List<Day> days;
}


interface Day {
    String day;
    List<Person> waiters;
}


interface Schedule {
    List<Days> weekday;

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