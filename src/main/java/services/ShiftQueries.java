package services;

import models.Day;
import models.Shift;
import org.jdbi.v3.core.Jdbi;
import java.util.ArrayList;
import java.util.List;

public class ShiftQueries {
    private Jdbi jdbi;
    public ShiftQueries(Jdbi conn){
        this.jdbi = conn;
    }
    public List<Shift> getShiftForUser(Long id) {
        jdbi.open();
        return new ArrayList<Shift>();
    }
    public List<Day> getAllDays() {
      jdbi.open();
      return jdbi.withHandle(handle -> handle.createQuery("select * from days").mapToBean(Day.class).list());
    }
    public List<Shift> getShiftForAllUsers() {
        jdbi.open();
    return   jdbi.withHandle(handle -> handle.createQuery("Select * from shifts").mapToBean(Shift.class).list());
    }
}
