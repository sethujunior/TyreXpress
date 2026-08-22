package za.ac.cput.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Customer customer;

    public User(){
    }
    public User(Builder builder){
        this.userId = builder.userId;
        this.email = builder.email;
        this.role = builder.role;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_Id='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder {
        private Long userId;
        private String email;
        private Role role;
        private String password;

        public Builder setuser_Id(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder setemail(String email) {
            this.email = email;
            return this;
        }
        public Builder setrole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setpassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.email = user.email;
            this.role = user.role;
            this.password = user.password;
            return this;
        }
        public User build() {
            return new User(this);
        }

    }
}
