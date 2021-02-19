package dao;

import models.Day;
import models.Shift;

import java.util.*;

public interface Shifts {
    List<Shift> getShiftForUser(Long id);

    List<Shift> getShiftsForUserAllUsers();

    List<Day> getAllDays();
}
