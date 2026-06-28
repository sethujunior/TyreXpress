package za.ac.cput.domain;

public class Cart {
    private String cartId;
    private String customerId;


    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customerId = builder.customerId;
    }

      public String getCartId() {
        return cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }

      public static class Builder {
        private String cartId;
        private String customerId;

        public Builder setCartId(String cartId) {
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

