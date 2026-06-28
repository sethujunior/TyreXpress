package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class CartItermFactory {

    public CartItem createCartItem(String cartItemId, int quantity, String productId, String cartId) {
        if (Helper.isNullOrEmpty(cartItemId) || Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(cartId)) {
            throw new NullPointerException("cartItemId, productId, or cartId is null or empty");
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