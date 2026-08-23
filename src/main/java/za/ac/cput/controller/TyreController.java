package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Tyre;
import za.ac.cput.service.TyreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/tyres")
public class TyreController {

    private TyreServiceImpl tyreService;

    public TyreController(TyreServiceImpl tyreService) {
        this.tyreService = tyreService;
    }

    @PostMapping("/create")
    public Tyre create(@RequestBody Tyre tyre) {
        return tyreService.create(tyre);
    }

    @GetMapping("/read/{id}")
    public Tyre read(@PathVariable Long id) {
        return tyreService.read(id);
    }

    @PutMapping("/update")
    public Tyre update(@RequestBody Tyre tyre) {
        return tyreService.update(tyre);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return tyreService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Tyre> getAll() {
        return tyreService.getAll();
    }
}