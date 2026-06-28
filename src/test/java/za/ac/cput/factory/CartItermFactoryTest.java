package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CartItem;

import static org.junit.jupiter.api.Assertions.*;

class CartItermFactoryTest {@Test
void createCartItem() {
    CartItermFactory cartItemFactory = new CartItermFactory();

    CartItem cartItem = cartItemFactory.createCartItem(
            "CI-909",
            3,
            "PROD-55",
            "CRT-101"
    );

    System.out.println(cartItem);
}
}