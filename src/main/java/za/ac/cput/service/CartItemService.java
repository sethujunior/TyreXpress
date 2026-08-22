package za.ac.cput.service;

import za.ac.cput.domain.*;
import za.ac.cput.repository.*;
import java.util.*;

public class CartItemService implements ICartItemService {
    private static CartItemService service = null;
    private ICartItermRepo repository;

    private CartItemService() {
        repository = CartItemRepository.getRepository();
    }

    public static CartItemService getService() {
        if (service == null) {
            service = new CartItemService();
        }
        return service;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return repository.create(cartItem);
    }

    @Override
    public CartItem read(String cartItemId) {
        return repository.read(cartItemId);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return repository.update(cartItem);
    }

    @Override
    public boolean delete(String cartItemId) {
        return repository.delete(cartItemId);
    }

    @Override
    public List<CartItem> getAll() {
        return repository.getAll();
    }
}