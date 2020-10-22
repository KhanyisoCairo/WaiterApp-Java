package waiter.admin;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin  {
    Map<String, Integer> admin = new HashMap<>();
    private Jdbi connection;

    public Admin(Jdbi connection) {
        this.connection = connection;
    }
    public void setAdmin(String name){
        connection.withHandle(handle -> handle.createQuery("INSERT INTO UserName (name) values (?)")
                .bind(name,1)
        );
    }
    public Map<String, Integer> getAdmin(){

        connection.useHandle(handle -> handle.execute("SELECT * FROM  UserName")
        );

        return admin;
    }
}
