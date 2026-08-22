package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.*;
import za.ac.cput.service.*;
import java.util.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public Address create(@RequestBody Address customer) {
        return service.create(customer);
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Address> getAll() {
        return service.getAll();
    }

}
