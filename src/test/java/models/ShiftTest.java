package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftTest {
    @Test
    void getShiftForUser()
    {
        Login login = new Login();
        Shift shift = new Shift();

        login.setUsername("cairo");
        shift.setDayName("Monday");

        assertEquals(login.getUsername(),"cairo");
        assertEquals(shift.getDayName(),"Monday");

    }
    @Test
    void getAllShifts(){

        Shift shift = new Shift();

        shift.setId(1L);

//        shift.setDayName("Monday");
        shift.setDayName("Saturday");

        assertEquals(shift.getDayName(),"Saturday");
        assertEquals(shift.getId(),1L);

    }

}
