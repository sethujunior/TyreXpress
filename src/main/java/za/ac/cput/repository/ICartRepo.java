package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import java.util.List;

public interface ICartRepo extends IRepository<Cart, String> {
    // This satisfies both IRepository's delee (if your base interface has the typo)
    // or the explicit contract rules.
    boolean delee(String cartId);

    boolean delete(String cartId);
    List<Cart> getAll();
}