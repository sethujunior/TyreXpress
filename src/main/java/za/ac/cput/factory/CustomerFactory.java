package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(String customer_id,String firstName,String lastName,String email,String user_Id) {
        if (Helper.isNullOrEmpty(customer_id)||Helper.isNullOrEmpty(firstName)||Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(user_Id)) {
            throw new NullPointerException("customer_id or firstName or lastName or email or user_Id");
        }
        if (Helper.isValidEmail(email)) {
            throw new NullPointerException("email is null or invalid");
        }
        return new Customer.Builder()
                .setcustomer_Id(customer_id)
                .setfirstName(firstName)
                .setlastName(lastName)
                .setemail(email)
                .setuser_Id(user_Id)
                .build();
    }
}
