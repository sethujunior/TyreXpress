package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.IAddressRepository;
import za.ac.cput.repository.IUserRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IAddressRepository addressRepository;

    private static Customer customer;
    private static User user;
    private static Address address;

    @Test
    @Order(1)
    void create() {
        user = UserFactory.createUser(
                null,
                "junior@gmail.com",
                Role.CUSTOMER,
                "12345"
        );
        user = userRepository.save(user);

        address = AddressFactory.createAddress(
                null,
                "12 Main Street",
                "Cape Town",
                "Western Cape",
                "7784",
                null
        );

        address = addressRepository.save(address);

        Customer newCustomer = CustomerFactory.createCustomer(
                null,
                "Junior",
                "Mdluli",
                "junior@gmail.com",
                "0824537952",
                user,
                address
        );

        customer = customerService.create(newCustomer);

        assertNotNull(customer);
        assertNotNull(customer.getCustomerId());
        assertEquals("Junior", customer.getFirstName());
        assertEquals("Mdluli", customer.getLastName());
        assertEquals("junior@gmail.com", customer.getEmail());

        System.out.println("Created Customer: " + customer);
    }

    @Test
    @Order(2)
    void read() {
        Customer found = customerService.read(customer.getCustomerId());

        assertNotNull(found);
        assertEquals(customer.getCustomerId(), found.getCustomerId());
        assertEquals("Junior", found.getFirstName());

        System.out.println("Read Customer: " + found);
    }

    @Test
    @Order(3)
    void update() {
        Customer updatedCustomer = new Customer.Builder()
                .copy(customer)
                .setfirstName("Junior Updated")
                .setPhone("0834567890")
                .build();

        Customer result = customerService.update(updatedCustomer);
        assertNotNull(result);
        assertEquals("Junior Updated", result.getFirstName());
        assertEquals("0834567890", result.getPhone());
        customer = result;

        System.out.println("Updated Customer: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = customerService.delete(customer.getCustomerId());
        assertTrue(deleted);
        Customer deletedCustomer = customerService.read(customer.getCustomerId());
        assertNull(deletedCustomer);

        System.out.println("Customer deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Customer> customers = customerService.getAll();
        assertNotNull(customers);
        System.out.println("All Customers: " + customers);
    }
}