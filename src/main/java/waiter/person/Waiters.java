package waiter.person;

import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Waiters {
    Map<String, Integer> waiters = new HashMap<>();
    private Jdbi jdbi;

    public  Waiters(){};

    public Waiters(Jdbi connection) {
        this.jdbi = connection;
    }

    public void setUser(String name) {
        jdbi.withHandle(handle -> handle.createQuery("INSERT INTO UserName (firstName) values (?)")
                .bind(name,1)
        );
    }
    public Map<String, Integer> getUser() {
        jdbi.useHandle(handle -> handle.execute("SELECT * FROM  UserName")
        );
        return waiters;
    }
 }
// public  void addUser(String name){
//     connection.withHandle(handle -> handle.createQuery("INSERT INTO UserName (name) values (?)")
//             .bind(name,1)
//     );

//        try {
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO UserName (name) values (?)");
//            ps.setString(1, name);
//            ps.execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        try {
//            PreparedStatement ps = connection.prepareStatement("SELECT * FROM  UserName");
//            ResultSet rs =ps.executeQuery();
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getInt("id"));
//
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

