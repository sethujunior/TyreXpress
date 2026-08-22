package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AddressFactory {

     public static Address createAddress(Long addressId, String street, String city, String province, String postalCode, Customer customer) {
         if (Helper.isNullOrEmpty(String.valueOf(addressId)) || Helper.isNullOrEmpty(street) || customer == null) {
             throw new IllegalArgumentException( "Customer is null or address is empty.");
         }
         if(!Helper.isValidPostalCode(postalCode)){
             throw new IllegalArgumentException("postalCode is null or invalid");
         }
         return new Address.Builder()
                 .setaddress_id(addressId)
                 .setstreet(street)
                 .setcity(city)
                 .setprovince(province)
                 .setpostalCode(postalCode)
                 .setCustomer(customer)
                 .build();
     }
}
