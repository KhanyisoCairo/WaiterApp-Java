package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaiterTest {
    @Test
    void getWaiter (){
        Waiter waiter = new Waiter();

        waiter.setUsername("cairo");

        assertEquals(waiter.getUsername(),"cairo");
    }


}
