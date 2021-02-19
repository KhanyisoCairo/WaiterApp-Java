package dao;

import models.Shift;
import models.Waiter;

import java.util.List;

public interface Admin {
    List<Waiter> getListOfWaiters();
    List<Shift> getAllShifts();
    boolean clearShifts();
}
