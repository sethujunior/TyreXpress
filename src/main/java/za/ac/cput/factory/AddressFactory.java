package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AddressFactory {

     public Address createAddress(String address_id, String street, String city, String province, String postalCode, String customer_id) {
         if (Helper.isNullOrEmpty(address_id) || Helper.isNullOrEmpty(street) || Helper.isNullOrEmpty(customer_id)) {
             throw new NullPointerException("address or customer id is null or empty");
         }
         if (Helper.isValidEmail(address_id)){
             throw new NullPointerException("address_id is null or invalid");
         }
         if(Helper.isValidPostalCode(postalCode)){
             throw new NullPointerException("postalCode is null or invalid");
         }
         return new Address.Builder()
                 .setaddress_id(address_id)
                 .setstreet(street)
                 .setcity(city)
                 .setprovince(province)
                 .setpostalCode(postalCode)
                 .setcustomer_Id(customer_id)
                 .build();
     }
}
