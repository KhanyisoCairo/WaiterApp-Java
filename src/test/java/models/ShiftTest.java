package models;

import dao.Shifts;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;
import services.ShiftQueries;
import services.ShiftService;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static webapp.App.getDatabaseConnection;

public class ShiftTest {
    private Jdbi jdbi;
    @Test
    void getShiftForUser() throws URISyntaxException
    {
        jdbi = getDatabaseConnection();
        Shifts waiterService = new ShiftService(new ShiftQueries(jdbi));

        List<Shift> shifts = waiterService.getShiftForUser(1L);

        assertEquals(waiterService.getShiftForUser(1L).get(6).getDayName(), "khanyiso");


    }
    @Test
    void getAllShifts() throws URISyntaxException{

        jdbi = getDatabaseConnection();
        Shifts waiterService = new ShiftService(new ShiftQueries(jdbi));

        List<Shift> shifts = waiterService.getShiftsForAllUsers();

        assertEquals(waiterService.getShiftsForAllUsers().get(6).getDayName(), "Friday");

    }

}
