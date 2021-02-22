package services;

import dao.Admin;
import dao.Shifts;
import models.Shift;
import models.Waiter;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static webapp.App.getDatabaseConnection;

public class AdminQueriesTest {

    private Jdbi jdbi;


    @Test
    void getListOfWaiters() throws URISyntaxException {

        jdbi = getDatabaseConnection();
        Admin adminServices = new AdminService(new AdminQueries(jdbi));
        List<Waiter> low = adminServices.getListOfWaiters();
        assertEquals(adminServices.getListOfWaiters().get(0).getUsername(), "khanyiso");

    }

    @Test
    void getAllShifts() throws URISyntaxException {

        jdbi = getDatabaseConnection();
        Shifts ss = new ShiftService(new ShiftQueries(jdbi));
        List<Shift> low = ss.getShiftsForAllUsers();
        assertEquals(low.get(0).getDayName(), "Monday");

    }
    @Test
    void  clearShifts() throws URISyntaxException{
        jdbi = getDatabaseConnection();
        Admin adminServices = new AdminService(new AdminQueries(jdbi));
        assertTrue(adminServices.clearShifts());

    }
}
