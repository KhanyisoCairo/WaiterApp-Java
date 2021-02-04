package waiter.days;

import org.jdbi.v3.core.Jdbi;
import waiter.DataBaseConnection;
import waiter.interfaces.Day;
import waiter.interfaces.Person;
import waiter.maps.DaysMap;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Days implements Day, Person {
    Map<String, Integer> Days = new HashMap<>();
    Jdbi jdbi;
    public void setDaysOfWeek(String daysOfWeek) throws URISyntaxException, SQLException {
        jdbi = DataBaseConnection.getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=codex&password=1234");
        jdbi.withHandle(handle -> handle.createQuery("INSERT INTO waiter.days.Days (Days_In_A_Week) values (?)")
                .bind(daysOfWeek, "Monday")
                .bind(daysOfWeek, "Tuesday")
                .bind(daysOfWeek, "Wednesday")
                .bind(daysOfWeek, "Thursday")
                .bind(daysOfWeek, "Friday")
                .bind(daysOfWeek, "Saturday")
                .bind(daysOfWeek, "Sunday")
        );

    }

    public List<DaysMap> getDaysOfWeek() throws URISyntaxException, SQLException {
        jdbi = DataBaseConnection.getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=khanyiso&password=cairo123");
//        return jdbi.useHandle(handle -> handle.execute("SELECT * FROM  DAYS"));
        List<DaysMap> days = jdbi.withHandle(handle -> handle.createQuery("SELECT * FROM  DAYS").mapToBean(DaysMap.class).list());
        return days;
    }


}
