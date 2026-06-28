package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class CartFactory {

    public Cart createCart(String cartId, String customerId) {
        if (Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(customerId)) {
            throw new NullPointerException("cartId or customerId is null or empty");
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomerId(customerId)
                .build();
    }
}
