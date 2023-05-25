package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository_DB userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        User createdUser = userRepository.createUser(user);

        Assertions.assertNotNull(createdUser);
        Assertions.assertNotNull(user.getUserID());
        Assertions.assertNotEquals(0, createdUser.getUserID());
        Assertions.assertEquals("Test", createdUser.getFirstName());
        Assertions.assertEquals("User", createdUser.getLastName());
        Assertions.assertEquals("testuser@example.com", createdUser.getEmail());
        Assertions.assertEquals("password", createdUser.getPassword());
    }

    @Test
    public void testGetUser() {
        String email = "testuser@example.com";
        String password = "password";

        User user = userRepository.getUser(email, password);

        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getUserID());
        Assertions.assertNotEquals(0, user.getUserID());
        Assertions.assertEquals("Test", user.getFirstName());
        Assertions.assertEquals("User", user.getLastName());
        Assertions.assertEquals("testuser@example.com", user.getEmail());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    public void testGetUserByEmail() {
        String email = "testuser@example.com";

        User user = userRepository.getUserByEmail(email);

        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getUserID());
        Assertions.assertNotEquals(0, user.getUserID());
        Assertions.assertEquals("Test", user.getFirstName());
        Assertions.assertEquals("User", user.getLastName());
        Assertions.assertEquals("testuser@example.com", user.getEmail());
        Assertions.assertEquals("password", user.getPassword());
    }
}
