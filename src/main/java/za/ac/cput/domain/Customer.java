package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer() {
    }
    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.user = builder.user;
        this.address = builder.address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                ", address=" + address +
                '}';
    }

    public static class  Builder {
        private Long customerId;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private User user;
        private Address address;

        public Builder setcustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setlastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setemail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }
        public Builder setaddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.getCustomerId();
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
            this.phone = customer.getPhone();
            this.email = customer.getEmail();
            this.user = customer.getUser();
            this.address = customer.getAddress();
            return this;
        }
        public Customer build() {
            return new Customer(this);
        }

    }
}
