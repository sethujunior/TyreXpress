package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.ICartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ICartService cartService;

    @Autowired
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
        Cart createdCart = cartService.create(cart);
        if (createdCart != null) {
            return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Cart> read(@PathVariable Long id) {
        Cart cart = cartService.read(id);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Cart> update(@RequestBody Cart cart) {
        Cart updatedCart = cartService.update(cart);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = cartService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAll() {
        List<Cart> carts = cartService.getAll();
        return ResponseEntity.ok(carts);
    }
}