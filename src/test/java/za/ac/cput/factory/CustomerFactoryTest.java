package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;


class CustomerFactoryTest {

    @Test
    void createCustomer() {
        User user = new User.Builder()
                .setuser_Id(1l)
                .setemail("Naruto@gmail.com")
                .setrole(Role.CUSTOMER)
                .setpassword("12345")
                .build();

        Address address = new Address.Builder()
                .setaddress_id(01L)
                .setstreet("Salubindza")
                .setcity("Hazyview")
                .setprovince("Mpumalanga")
                .setpostalCode("1242")
                .build();

        Customer customer1 = new Customer.Builder()
                .setcustomerId(01l)
                .setfirstName("Naruto")
                .setlastName("Uzumaki")
                .setPhone("0824537952")
                .setemail("Naruto@gmail.com")
                .setUser(user)
                .setaddress(address)
                .build();

        System.out.println(customer1);
    }
}