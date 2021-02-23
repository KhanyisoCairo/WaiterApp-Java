package dao;

import models.Day;
import models.Shift;

import java.util.*;

public interface Shifts {
    List<Shift> getShiftForUser(Long id);

    List<Shift> getShiftsForAllUsers();

    List<Day> getAllDays();

//    List<Shift> getShiftForUser();
}
