import org.jdbi.v3.core.Jdbi;

import java.util.HashMap;
import java.util.Map;

public class Days {
    Map<String, Integer> Days = new HashMap<>();

    public Jdbi connection;

    public Days(Jdbi connection) {
        this.connection = connection;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        connection.withHandle(handle -> handle.createQuery("INSERT INTO Days (Days_In_A_Week) values (?)")
                .bind(daysOfWeek, "Monday")
                .bind(daysOfWeek, "Tuesday")
                .bind(daysOfWeek, "Wednesday")
                .bind(daysOfWeek, "Thursday")
                .bind(daysOfWeek, "Friday")
                .bind(daysOfWeek, "Saturday")
                .bind(daysOfWeek, "Sunday")
        );
    }

    public void getDaysOfWeek() {
        connection.useHandle(handle -> handle.execute("SELECT * FROM  Days")
        );
    }


}
