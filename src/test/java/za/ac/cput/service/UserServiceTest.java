package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    private UserService userService;
    private User user = UserFactory.createUser(12L,"sethu@gmail.com", Role.CUSTOMER,"1222");

    @Test
    @Order(1)
    void create() {
        User created = userService.create(user);
        assertNotNull(created);
        System.out.println("Created User: " + created);
    }

    @Test
    @Order(2)
    void read() {

    }

    @Test
    @Order(3)
    void update() {
    }

    @Test
    @Order(4)
    void delete() {
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Get All Users" + userService.getAll());
    }
}