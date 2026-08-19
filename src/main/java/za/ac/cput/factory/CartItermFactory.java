package za.ac.cput.factory;

import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

public class CartItermFactory {

    public static CartItem createCartItem(int quantity, String productId, Long cartId) {
        if (cartId == null) {
            throw new IllegalArgumentException("cartId cannot be null");
        }
        if (Helper.isNullOrEmpty(productId)) {
            throw new IllegalArgumentException("productId is null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        return new CartItem.Builder()
                .setQuantity(quantity)
                .setProductId(productId)
                .setCartId(cartId)
                .build();
    }

    public static CartItem createCartItem(Long cartItemId, int quantity, String productId, Long cartId) {
        if (cartId == null) {
            throw new IllegalArgumentException("cartId cannot be null");
        }
        if (Helper.isNullOrEmpty(productId)) {
            throw new IllegalArgumentException("productId is null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        return new CartItem.Builder()
                .setCartItemId(cartItemId)
                .setQuantity(quantity)
                .setProductId(productId)
                .setCartId(cartId)
                .build();
    }
}