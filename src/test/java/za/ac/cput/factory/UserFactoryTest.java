package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user1 = new User.Builder()
                .setuser_Id(22l)
                .setemail("sethu@gmail.com")
                .setrole(Role.ADMIN)
                .setpassword("123456")
                .build();

        System.out.println(user1);
    }
}