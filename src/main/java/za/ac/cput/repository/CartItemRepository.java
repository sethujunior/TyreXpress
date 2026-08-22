package za.ac.cput.repository;

import za.ac.cput.domain.CartItem;
import java.util.ArrayList;
import java.util.List;

public class CartItemRepository implements ICartItermRepo {
    private static CartItemRepository repository = null;
    private List<CartItem> cartItemDB;

    private CartItemRepository() {
        cartItemDB = new ArrayList<>();
    }

    public static CartItemRepository getRepository() {
        if (repository == null) {
            repository = new CartItemRepository();
        }
        return repository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        boolean success = cartItemDB.add(cartItem);
        if (success) {
            return cartItem;
        }
        return null;
    }

    @Override
    public CartItem read(String cartItemId) {
        for (CartItem ci : cartItemDB) {
            if (ci.getCartItemId().equals(cartItemId)) {
                return ci;
            }
        }
        return null;
    }

    @Override
    public CartItem update(CartItem cartItem) {
        CartItem oldCartItem = read(cartItem.getCartItemId());
        if (oldCartItem != null) {
            cartItemDB.remove(oldCartItem);
            cartItemDB.add(cartItem);
            return cartItem;
        }
        return null;
    }

    @Override
    public boolean delee(String cartItemId) {
        return delete(cartItemId);
    }

    @Override
    public boolean delete(String cartItemId) {
        CartItem itemToDelete = read(cartItemId);
        if (itemToDelete == null) {
            return false;
        }
        return cartItemDB.remove(itemToDelete);
    }

    @Override
    public List<CartItem> getAll() {
        return cartItemDB;
    }
}