package services;

import dao.Shifts;
import models.Day;
import models.Shift;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static webapp.App.getDatabaseConnection;

public class ShiftQueriesTest {
    private Jdbi jdbi;

    @Test
    void getAllDays()throws URISyntaxException {
        jdbi = getDatabaseConnection();
        Shifts days = new ShiftService(new ShiftQueries(jdbi));
        List<Day> allDays = days.getAllDays();

        assertEquals(allDays.get(0).getName(), "Sunday");
    }

    @Test
    void getShiftForUser()throws URISyntaxException {
        jdbi = getDatabaseConnection();
        Shifts days = new ShiftService(new ShiftQueries(jdbi));
        List<Shift> allDays = days.getShiftForUser(1L);

        assertEquals(allDays.get(0).getDayName(), "Monday");
    }
}
