package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.util.Helper;

public class CartFactory {

    public static Cart createCart(String customerId) {
        if (Helper.isNullOrEmpty(customerId)) {
            throw new IllegalArgumentException("customerId is null or empty");
        }

        return new Cart.Builder()
                .setCustomerId(customerId)
                .build();
    }

    public static Cart createCart(Long cartId, String customerId) {
        if (Helper.isNullOrEmpty(customerId)) {
            throw new IllegalArgumentException("customerId is null or empty");
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomerId(customerId)
                .build();
    }
}