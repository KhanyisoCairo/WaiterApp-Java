package waiter.person.Register;

import org.jdbi.v3.core.Jdbi;
import waiter.DataBaseConnection;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class RegisterWaiter {

    public RegisterWaiter() throws URISyntaxException, SQLException {
    }
    public void registerWaiter(Register register) {
        String firstName = register.getFirstName();
        String lastname = register.getLastname();
        String password = register.getPassword();
        String confirmPassword = register.getConfirmPassword();
    }
}
class RegisterUser {
    public void setuserToDatabase(String firstName, String lastName,String password,String confirmPassword) throws URISyntaxException, SQLException {
        Register register = new Register();
        register.setFirstName("khanyiso");
        register.setLastName("yezo");
        register.setPassword("codex");
        register.setConfirmPassword("codex");

        Jdbi jdbi;
        jdbi = DataBaseConnection.getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=codex&password=1234");
        jdbi.withHandle(handle -> handle.createQuery("INSERT INTO UserName (firstName,lastName,password,confirmPassword) values (?,?,?,?)")
                .bind(firstName,register.getFirstName())
                .bind(lastName,register.getLastname())
                .bind(password,register.getPassword())
                .bind(confirmPassword,register.getConfirmPassword())
        );
    }
    public static void main(String[] args) throws URISyntaxException, SQLException {
        Register register = new Register();
        register.setFirstName("Khanyiso");
        register.setLastName("yezo");
        register.setPassword("codex");
        register.setConfirmPassword("codex");
        RegisterUser registerUser =  new RegisterUser();
        registerUser.setuserToDatabase(register.getFirstName(),register.getLastname(),register.getPassword(),register.getConfirmPassword());

    }
}
