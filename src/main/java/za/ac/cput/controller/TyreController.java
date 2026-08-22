package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Tyre;
import za.ac.cput.service.TyreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/tyres")
public class TyreController {

    private final TyreServiceImpl service = TyreServiceImpl.getService();

    @PostMapping("/create")
    public Tyre create(@RequestBody Tyre tyre) {
        return service.create(tyre);
    }

    @GetMapping("/read/{id}")
    public Tyre read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Tyre update(@RequestBody Tyre tyre) {
        return service.update(tyre);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Tyre> getAll() {
        return service.getAll();
    }
}