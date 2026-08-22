package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(Long customerid,String firstName,String lastName,String email,String phone,User user, Address address) {

        if (Helper.isNullOrEmpty(String.valueOf(customerid))||Helper.isNullOrEmpty(firstName)||Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || user == null || address == null) {
            throw new IllegalArgumentException( "Customer ID, first name, last name, email, user or address is invalid.");        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("email is null or invalid");
        }
        if (Helper.isNumeric(phone)) {
            throw new IllegalArgumentException("phone number is null or invalid");
        }
        return new Customer.Builder()
                .setcustomerId(customerid)
                .setfirstName(firstName)
                .setlastName(lastName)
                .setPhone(phone)
                .setemail(email)
                .setUser(user)
                .setaddress(address)
                .build();
    }
}
