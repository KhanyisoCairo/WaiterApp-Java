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
    private Jdbi connection;

    public Waiters(Jdbi connection) {
        this.connection = connection;
    }

    public void setUser(String name) {
        connection.withHandle(handle -> handle.createQuery("INSERT INTO UserName (name) values (?)")
                .bind(name,1)
        );
        //        try {
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO UserName (name) values (?)");
//            ps.setString(1, name);
//            ps.execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
    public Map<String, Integer> getUser() {
        connection.useHandle(handle -> handle.execute("SELECT * FROM  UserName")
        );
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

        return waiters;
    }



// public  void addUser(String name){
//     connection.withHandle(handle -> handle.createQuery("INSERT INTO UserName (name) values (?)")
//             .bind(name,1)
//     );

 }


