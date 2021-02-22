package services;

import models.Shift;
import models.Waiter;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class AdminQueries {

    private Jdbi jdbi;

    public AdminQueries(Jdbi conn) {
        this.jdbi = conn;
    }

    public AdminQueries() {

    }

    public List<Waiter> getListOfWaiters() {
        jdbi.open();
        return jdbi.withHandle(handle -> handle.createQuery("select * from waiters").mapToBean(Waiter.class
        ).list());
    }

    public boolean clearShift() {
        jdbi.open();
        jdbi.useHandle(handle -> handle.createQuery("delete shifts.id as id, waiters.username as waiter_name, days.name as day_name from shifts join days on shifts.day_id = days.id join waiters on shifts.waiter_id = waiters.id"));
        return true;
    }

    public List<Shift> getAllShifts() {
        jdbi.open();
      return   jdbi.withHandle(handle -> handle.createQuery("select * from days").mapToBean(Shift.class).list());
    }
}
