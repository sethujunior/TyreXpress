package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.ICartRepo;

import java.util.List;

@Service
public class CartService implements ICartService {

    private final ICartRepo repository;

    @Autowired
    public CartService(ICartRepo repository) {
        this.repository = repository;
    }

    @Override
    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart read(Long cartId) {
        return repository.findById(cartId).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public boolean delete(Long cartId) {
        if (repository.existsById(cartId)) {
            repository.deleteById(cartId);
            return true;
        }
        return false;
    }

    @Override
    public List<Cart> getAll() {
        return repository.findAll();
    }
}