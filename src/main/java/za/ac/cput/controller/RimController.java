package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Rim;
import za.ac.cput.service.RimServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rims")
public class RimController {

    private final RimServiceImpl service = RimServiceImpl.getService();

    @PostMapping("/create")
    public Rim create(@RequestBody Rim rim) {
        return service.create(rim);
    }

    @GetMapping("/read/{id}")
    public Rim read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Rim update(@RequestBody Rim rim) {
        return service.update(rim);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Rim> getAll() {
        return service.getAll();
    }
}