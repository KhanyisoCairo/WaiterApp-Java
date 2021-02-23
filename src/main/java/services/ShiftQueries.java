package services;

import models.Day;
import models.Shift;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

public class ShiftQueries {
    private Jdbi jdbi;

    public ShiftQueries(Jdbi conn) {
        this.jdbi = conn;
    }

    public List<Shift> getShiftForUser(Long id) {
        jdbi.open();
        return jdbi.withHandle(handle -> handle.createQuery("Select shifts.id as id, waiters.username as waiter_name, days.name as day_name from shifts join days on shifts.day_id = days.id join waiters on shifts.waiter_id = waiters.id").mapToBean(Shift.class).list());
    }

    public List<Day> getAllDays() {
        jdbi.open();
        return jdbi.withHandle(handle -> handle.createQuery("select * from days").mapToBean(Day.class).list());
    }


    public List<Shift> getShiftForAllUsers() {
        jdbi.open();
        return jdbi.withHandle(handle -> handle.createQuery("Select shifts.id as id, waiters.username as waiter_name, days.name as day_name from shifts join days on shifts.day_id = days.id join waiters on shifts.waiter_id = waiters.id").mapToBean(Shift.class).list());
    }
}
