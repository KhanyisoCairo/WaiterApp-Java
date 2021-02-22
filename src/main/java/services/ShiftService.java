package services;

import dao.Shifts;
import models.Day;
import models.Shift;

import java.util.List;


public class ShiftService implements Shifts {

    ShiftQueries queries;

    public ShiftService(ShiftQueries queries) {
        this.queries = queries;
    }

    @Override
    public List<Shift> getShiftForUser(Long id) {
        return this.queries.getShiftForUser(id);
    }

    @Override
    public List<Shift> getShiftsForAllUsers() {
        return this.queries.getShiftForAllUsers();
    }

    @Override
    public List<Day> getAllDays() {
        return this.queries.getAllDays();
    }
}
