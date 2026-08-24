package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {

    @Autowired
    private AddressService addressService;
    private static Address address;

    @Test
    @Order(1)
    void create() {

        Address newAddress = AddressFactory.createAddress(
                null,
                "12 Main Street",
                "Cape Town",
                "Western Cape",
                "7784"
        );

        address = addressService.create(newAddress);

        assertNotNull(address);
        assertNotNull(address.getAddressId());
        assertEquals("12 Main Street", address.getStreet());
        assertEquals("Cape Town", address.getCity());
        assertEquals("Western Cape", address.getProvince());
        assertEquals("7784", address.getPostalCode());

        System.out.println("Created Address: " + address);
    }

    @Test
    @Order(2)
    void read() {
        Address found = addressService.read(address.getAddressId());

        assertNotNull(found);
        assertEquals(address.getAddressId(), found.getAddressId());
        assertEquals("12 Main Street", found.getStreet());

        System.out.println("Read Address: " + found);
    }

    @Test
    @Order(3)
    void update() {

        Address updatedAddress = new Address.Builder()
                .copy(address)
                .setstreet("25 Long Street")
                .setcity("Bellville")
                .build();

        Address result = addressService.update(updatedAddress);
        assertNotNull(result);
        assertEquals("25 Long Street", result.getStreet());
        assertEquals("Bellville", result.getCity());
        address = result;

        System.out.println("Updated Address: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = addressService.delete(address.getAddressId());

        assertTrue(deleted);
        Address deletedAddress = addressService.read(address.getAddressId());
        assertNull(deletedAddress);

        System.out.println("Address deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Address> addresses = addressService.getAll();
        assertNotNull(addresses);

        System.out.println("All Addresses: " + addresses);
    }
}