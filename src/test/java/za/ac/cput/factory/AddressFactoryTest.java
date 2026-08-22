package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress() {
        Address address = new Address.Builder()
                .setaddress_id(1l)
                .setstreet("Salubindza")
                .setcity("Hazyview")
                .setprovince("Mpumalanga")
                .setpostalCode("1242")
                .build();
        System.out.println(address);
    }
}