package practiceQuestions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserManagerTest {

    private UserManager userManager;
    // Instance initializer - using this to test if test classes are created once for each test
    {
        System.out.println("New test instance created! HashCode: " + this.hashCode());
    }


    // actually no need since each test uses a new test class instance...
    // but this is good practice (esp in DI frameworks like Spring)
    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        userManager.addUser("admin", "adminPassword");
    }

    @Test
    public void addUser_NonexistentUser() {
        boolean success = userManager.addUser("admin2", "onetwothree");
        assertTrue(success);
        // this test actually implicitly tests "returns user password"
        String password = userManager.findUser("admin2");
        assertEquals("onetwothree", password);
    }

    @Test
    public void addUser_ExistentUser() {
        boolean success = userManager.addUser("admin", "onetwothree");
        assertFalse(success);
    }

    @Test
    public void findUser_ExistentUser() {
        String password = userManager.findUser("admin");
        assertEquals("adminPassword", password);
    }

    @Test
    public void findUser_NonexistentUser() {
        String password = userManager.findUser("foobar");
        assertNull(password);
    }

    @Test
    public void removeUser_ExistentUser() throws Exception {
        boolean success = userManager.removeUser("admin");
        assertTrue(success);

        // check if its really removed
        String password = userManager.findUser("admin");
        assertNull(password);
    }

    @Test
    public void removeUser_NonexistentUser() throws Exception {
        boolean success = userManager.removeUser("foobar");
        assertFalse(success);
    }


}
