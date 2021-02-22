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

public class WaiterTest {

    private Jdbi jdbi;
    @Test
    void getWaiter ()throws URISyntaxException {

        jdbi = getDatabaseConnection();
        Shifts waiterService = new ShiftService(new ShiftQueries(jdbi));

//        List<Waiter> day = waiterService.;

        assertEquals(waiterService.getAllDays().get(3).getName(), "Wednesday");
//        Waiter waiter = new Waiter();
//
//        waiter.setUsername("cairo");
//
//        assertEquals(waiter.getUsername(),"cairo");
    }


}
