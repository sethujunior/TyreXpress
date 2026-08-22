package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    private int quantity;
    private String productId;
    private Long cartId;

    protected CartItem() {}

    private CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.quantity = builder.quantity;
        this.productId = builder.productId;
        this.cartId = builder.cartId;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Long getCartId() {
        return cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity &&
                Objects.equals(cartItemId, cartItem.cartItemId) &&
                Objects.equals(productId, cartItem.productId) &&
                Objects.equals(cartId, cartItem.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId, quantity, productId, cartId);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                ", productId='" + productId + '\'' +
                ", cartId=" + cartId +
                '}';
    }

    public static class Builder {
        private Long cartItemId;
        private int quantity;
        private String productId;
        private Long cartId;

        public Builder setCartItemId(Long cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setCartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemId = cartItem.cartItemId;
            this.quantity = cartItem.quantity;
            this.productId = cartItem.productId;
            this.cartId = cartItem.cartId;
            return this;
        }



        public CartItem build() {
            return new CartItem(this);
        }
    }
}