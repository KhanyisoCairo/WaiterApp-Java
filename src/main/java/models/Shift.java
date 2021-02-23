package models;

import dao.Shifts;
import services.ShiftQueries;

import java.util.List;

public class Shift {
    private Long id;
    private String waiterName;
    private String dayName;
//    private ShiftQueries queries;
//
//    public  ShiftService(ShiftQueries queries) {
//        this.queries = queries;
//    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }


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

//    @Override
//    public List<Shift> getShiftForUser(Long id) {
//        return this.queries.getShiftForUser(id);
//    }
//
//    @Override
//    public List<Shift> getShiftsForAllUsers() {
//        return this.queries.getShiftForAllUsers();
//    }
//
//    @Override
//    public List<Day> getAllDays() {
//        return this.queries.getAllDays();
//    }
}
//    public Day(){}
//
//    public Day(Long id, String dayName) {
//        this.id = id;
//        this.dayName = dayName;
//    }