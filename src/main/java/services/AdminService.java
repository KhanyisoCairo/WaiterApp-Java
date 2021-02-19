package services;

import dao.Admin;
import models.Shift;
import models.Waiter;

import java.util.List;

public class AdminService implements Admin {

    private AdminQueries queries;

    public AdminService(AdminQueries queries) {
        this.queries = queries;
    }

    @Override
    public List<Waiter> getListOfWaiters() {
        return this.queries.getListOfWaiters();
    }

    @Override
    public List<Shift> getAllShifts() {

        return  this.queries.getAllShifts();
    }

    @Override
    public boolean clearShifts() {
        return this.queries.clearShift();
    }
}
