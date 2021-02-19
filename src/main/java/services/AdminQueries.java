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

    public List<Waiter> getListOfWaiters() {
        jdbi.open();
        return jdbi.withHandle(handle -> handle.createQuery("select * from waiters").mapToBean(Waiter.class
        ).list());
    }

    public boolean clearShift() {
        jdbi.open();
        jdbi.useHandle(handle -> handle.execute("delete * from shifts"));
        return true;
    }

    public List<Shift> getAllShifts() {
        jdbi.open();
      return   jdbi.withHandle(handle -> handle.createQuery("select * days").mapToBean(Shift.class).list());
    }
}
