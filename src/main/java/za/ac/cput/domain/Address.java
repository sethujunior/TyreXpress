package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Customer customer;

    public Address() {
    }
    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.customer = builder.customer;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getStreet() {
        return street;
    }
    public Customer getCustomer() {
        return customer;
    }


    @Override
    public String toString() {
        return "Address{" +
                "address_id='" + addressId + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static  class Builder{
        private Long addressId;
        private String street;
        private String city;
        private String province;
        private String postalCode;
        private Customer customer;

        public Builder setaddress_id(Long addressId) {
            this.addressId = addressId;
            return this;
        }
        public Builder setstreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setcity(String city) {
            this.city = city;
            return this;
        }
        public Builder setprovince(String province) {
            this.province = province;
            return this;
        }
        public Builder setpostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }


        public Builder copy(Address address){
            this.addressId = address.addressId;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.postalCode = address.postalCode;
            this.customer = address.customer;
            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}
