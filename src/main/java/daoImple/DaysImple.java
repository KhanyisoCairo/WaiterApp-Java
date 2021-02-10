package daoImple;

import dao.DaysDao;
import model.dao.Day;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import waiter.days.Days;

import java.util.List;

public class DaysImple implements DaysDao {
 private Jdbi jdbi;

    public DaysImple(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<Day> getDays() {
        return jdbi.withHandle(handle -> handle.createQuery("Select id,day_name from Days")
        .mapToBean(Day.class)
                .list()
        );
    }


}
