import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Waiters {
    Map<String,Integer> waiters = new HashMap<>();

    public void setUser(String name) {
        if (waiters.equals(name)) {
            waiters.put(name,waiters.get(name)+1);
        } else {
            waiters.put(name, 1);
        }
    }

    public Map<String,Integer> getUser(){
        return waiters;
    }


}
