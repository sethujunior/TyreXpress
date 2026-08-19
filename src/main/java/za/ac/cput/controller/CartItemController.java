package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.ICartItemService;

import java.util.List;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

    private final ICartItemService cartItemService;

    @Autowired
    public CartItemController(ICartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<CartItem> create(@RequestBody CartItem cartItem) {
        CartItem createdItem = cartItemService.create(cartItem);
        if (createdItem != null) {
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<CartItem> read(@PathVariable Long id) {
        CartItem item = cartItemService.read(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<CartItem> update(@RequestBody CartItem cartItem) {
        CartItem updatedItem = cartItemService.update(cartItem);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = cartItemService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartItem>> getAll() {
        List<CartItem> items = cartItemService.getAll();
        return ResponseEntity.ok(items);
    }
}