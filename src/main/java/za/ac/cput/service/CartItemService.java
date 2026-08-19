package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.ICartItemRepo;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {

    private final ICartItemRepo repository;

    @Autowired
    public CartItemService(ICartItemRepo repository) {
        this.repository = repository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public CartItem read(Long cartItemId) {
        return repository.findById(cartItemId).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public boolean delete(Long cartItemId) {
        if (repository.existsById(cartItemId)) {
            repository.deleteById(cartItemId);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItem> getAll() {
        return repository.findAll();
    }
}