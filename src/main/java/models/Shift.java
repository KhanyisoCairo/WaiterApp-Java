package models;

import org.jdbi.v3.core.Jdbi;

public class Shift {
    private Long id;
    private String dayName;

//    public Day(){}
//
//    public Day(Long id, String dayName) {
//        this.id = id;
//        this.dayName = dayName;
//    }

    public Long getId() {
        return id;
    }

    public String getDayName() {
        return dayName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", dayName='" + dayName + '\'' +
                '}';
    }
}
