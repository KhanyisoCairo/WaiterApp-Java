//package waiter;
//
//import org.jdbi.v3.core.Jdbi;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//
//public class Login {
//    private String username;
//    private String password;
//
//    public static void main(String[] args) {
//
//        new Login(Jdbi.create("jdbc:postgresql://localhost/waiters?user=codex&password=1234")).checkUserDoesExists("king");
//    }
//public Login(){};
//
//    private Jdbi jdbi;
//    public Login(String username, String password) throws URISyntaxException, SQLException {
//    }
//
//    public Login(Jdbi jdbi) {
//        this.jdbi = jdbi;
//    }
//
//    public String getPassword() {
//        jdbi.withHandle(handle -> handle.createUpdate(""));
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void checkUserDoesExists(String username){
//
////Wanted to check if the user is has entered a correct username and compare with the correct password if one of them is incorrect the user wont be able to logIn on the app
//        System.out.println(
//                jdbi.withHandle(handle -> handle.createQuery("SELECT * from UserName WHERE firstName = ?"))
//                        .bind(0, username)
//                        .mapTo(String.class)
//                        .list()
//                        .size() >= 1
//        );
//
//    }
//
//
//}
