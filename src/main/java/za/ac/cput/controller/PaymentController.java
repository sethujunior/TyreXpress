/* PaymentController.java
   Payment Controller class
   Author: Bongikazi Mnyamana (222718404)
   Date: 13 July 2026 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return service.update(payment);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/getall")
    public List<Payment> getAll() {
        return service.getAll();
    }
}