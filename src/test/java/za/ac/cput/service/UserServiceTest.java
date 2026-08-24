package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserService userService;
    private static User user;
    private static Long generatedId;

    @Test
    @Order(1)
    void create() {
        User newUser = UserFactory.createUser(
                null,
                "junior2@gmail.com",
                Role.CUSTOMER,
                "1222"
        );

        User created = userService.create(newUser);
        assertNotNull(created);
        assertNotNull(created.getUserId());

        generatedId = created.getUserId();
        user = created;

        System.out.println("Created User: " + user.toString());
    }

    @Test
    @Order(2)
    void read() {
        User foundUser = userService.read(generatedId);

        assertNotNull(foundUser);
        assertEquals(generatedId, foundUser.getUserId());

        System.out.println("Read User ID: " + foundUser.getUserId());
        System.out.println("Read User"+user.toString());

    }

    @Test
    @Order(3)
    void update() {
        User toUpdate = new User.Builder()
                .setuser_Id(generatedId)
                .setemail(user.getEmail())
                .setrole(Role.CUSTOMER)
                .setpassword("2468")
                .build();

        User updated = userService.update(toUpdate);

        assertNotNull(updated);
        assertEquals("2468", updated.getPassword());
        System.out.println("Updated Password: " + updated.getPassword());
    }

    @Test
    @Order(4)
    @Disabled
    void delete() {
        boolean deleted = userService.delete(generatedId);
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        List<User> users = userService.getAll();
        assertNotNull(users);
        System.out.println("Number of Users: " + users.size());
    }
}