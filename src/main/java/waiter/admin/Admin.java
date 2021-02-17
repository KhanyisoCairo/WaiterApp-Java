package waiter.admin;

import org.jdbi.v3.core.Jdbi;
import waiter.interfaces.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin implements Schedule {
    Map<String, Integer> admin = new HashMap<>();
    private Jdbi jdbi;

    public Admin(Jdbi connection) {
        this.jdbi = connection;
    }
    public void setAdmin(String name){
        jdbi.withHandle(handle -> handle.createQuery("INSERT INTO users (first_name) values (?)")
                .bind(name,1)
        );
    }
    public Map<String, Integer> getAdmin(){
        jdbi.useHandle(handle -> handle.execute("SELECT * FROM  users")
        );
        return admin;
    }
}
