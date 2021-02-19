package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DayTest {
    @Test
    void shouldReturnNameAndId()
    {
        Day day  = new Day();

        day.setId(1);
        day.setId(2);
        day.setId(3);
        day.setId(4);
        day.setId(5);
        day.setId(6);
        day.setId(7);

        day.setName("Sunday");
        day.setName("Monday");
        day.setName("Tuesday");
        day.setName("Wednesday");
        day.setName("Thursday");
        day.setName("Friday");
        day.setName("Saturday");

        assertEquals(day.getName(),"Saturday");
        assertEquals(day.getId(),7);
    }
}
