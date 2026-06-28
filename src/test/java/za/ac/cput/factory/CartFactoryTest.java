package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void createCart() {
                CartFactory cartFactory = new CartFactory();

               Cart cart = cartFactory.createCart("CRT-101", "01");

                System.out.println(cart);
    }
}