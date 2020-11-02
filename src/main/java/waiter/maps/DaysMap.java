package waiter.maps;

public class DaysMap {
    private int id;
    private String DaysInAWeek;

    public DaysMap(){}

    public DaysMap(int id, String daysInAWeek) {
        this.id = id;
        DaysInAWeek = daysInAWeek;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDaysInAWeek(String daysInAWeek) {
        System.out.println(daysInAWeek);
        DaysInAWeek = daysInAWeek;
    }

    public int getId() {
        return id;
    }

    public String getDaysInAWeek() {
        return DaysInAWeek;
    }
}
