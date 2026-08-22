package za.ac.cput.service;

import za.ac.cput.domain.*;
import za.ac.cput.repository.*;
import java.util.*;

public class CartService implements ICartService {
    private static CartService service = null;
    private ICartRepo repository;

    private CartService() {
            this.repository = CartRepository.getRepository();
    }

    public static CartService getService() {
        if (service == null) {
            service = new CartService();
        }
        return service;
    }

    @Override
    public Cart create(Cart cart) {
        return repository.create(cart);
    }

    @Override
    public Cart read(String cartId) {
        return repository.read(cartId);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.update(cart);
    }

    @Override
    public boolean delete(String cartId) {
        return repository.delete(cartId);
    }

    @Override
    public List<Cart> getAll() {
        return repository.getAll();
    }
}