package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private String customerId;

    protected Cart() {}

    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customerId = builder.customerId;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId) && Objects.equals(customerId, cart.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, customerId);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    public static class Builder {
        private Long cartId;
        private String customerId;

        public Builder setCartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.customerId = cart.customerId;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}