package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    void getPasswordAndUsername(){
        Login login = new Login();

        login.setPassword("1234");
        login.setUsername("cairo");
        login.setId(1L);

        assertEquals(login.getPassword(),"1234");
        assertEquals(login.getUsername(),"cairo");
        assertEquals(login.getId(),1L);
    }
}
