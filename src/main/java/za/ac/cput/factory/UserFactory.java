package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(Long userId,  String email, Role role,String password) {
        if(Helper.isNullOrEmpty(String.valueOf(userId)) || Helper.isNullOrEmpty(email)){
            throw new IllegalArgumentException("userId or email is null or empty");
        }
        if(!Helper.isValidEmail(email)){
            throw new IllegalArgumentException("email is null or invalid");
        }
        return new User.Builder()
                .setuser_Id(userId)
                .setemail(email)
                .setrole(role)
                .setpassword(password)
                .build();
    }
}
