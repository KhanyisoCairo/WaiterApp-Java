package services;

import dao.Admin;
import org.junit.jupiter.api.Test;
import webapp.App;

import java.net.URISyntaxException;

public class AdminServiceTest {

    @Test
    public void testIt() throws URISyntaxException {
        Admin a = new AdminService(new AdminQueries(App.getDatabaseConnection()));

        a.getListOfWaiters();
        a.clearShifts();
        a.getAllShifts();
    }
}
