package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String user_id,  String email, Role role) {
        if(Helper.isNullOrEmpty(user_id) || Helper.isNullOrEmpty(email)){
            throw new IllegalArgumentException("user_id or email is null or empty");
        }
        return new User.Builder()
                .setuser_Id(user_id)
                .setemail(email)
                .setrole(role)
                .build();
    }
}
