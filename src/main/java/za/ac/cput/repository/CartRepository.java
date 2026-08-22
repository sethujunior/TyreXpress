package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepo {
    private static CartRepository repository = null;
    private List<Cart> cartDB;

    private CartRepository() {
        cartDB = new ArrayList<>();
    }

    public static CartRepository getRepository() {
        if (repository == null) {
            repository = new CartRepository();
        }
        return repository;
    }

    @Override
    public Cart create(Cart cart) {
        boolean success = cartDB.add(cart);
        if (success) {
            return cart;
        }
        return null;
    }

    @Override
    public Cart read(String cartId) {
        for (Cart c : cartDB) {
            if (c.getCartId().equals(cartId)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Cart update(Cart cart) {
        Cart oldCart = read(cart.getCartId());
        if (oldCart != null) {
            cartDB.remove(oldCart);
            cartDB.add(cart);
            return cart;
        }
        return null;
    }


    @Override
    public boolean delee(String cartId) {
        return delete(cartId);
    }

    @Override
    public boolean delete(String cartId) {
        Cart cartToDelete = read(cartId);
        if (cartToDelete == null) {
            return false;
        }
        return cartDB.remove(cartToDelete);
    }

    @Override
    public List<Cart> getAll() {
        return cartDB;
    }
}