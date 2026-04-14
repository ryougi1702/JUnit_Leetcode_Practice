package practiceQuestions;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    // In-memory store for users: key=username, value=password
    private Map<String, String> users = new HashMap<>();

    // Adds a new user if the username and password are valid and unique
    public boolean addUser(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        return true;
    }

    // Removes an existing user
    public boolean removeUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            return true;
        }
        return false;
    }

    // Retrieves the password for a given user
    public String findUser(String username) {
        return users.get(username);
    }
}
