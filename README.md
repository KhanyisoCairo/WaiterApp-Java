# WaiterApp-Java



```java

interface waiter.interfaces.Person {
    String fName, lName, username, id, email, password;
    List<waiter.interfaces.Day> days;
}


interface waiter.interfaces.Day {
    String day;
    List<waiter.interfaces.Person> waiters;
}


interface waiter.interfaces.Schedule {
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