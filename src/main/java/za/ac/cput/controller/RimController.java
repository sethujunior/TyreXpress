package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Rim;
import za.ac.cput.service.RimServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rims")
public class RimController {

    private RimServiceImpl rimService;

    public RimController(RimServiceImpl rimService) {
        this.rimService = rimService;
    }

    @PostMapping("/create")
    public Rim create(@RequestBody Rim rim) {
        return rimService.create(rim);
    }

    @GetMapping("/read/{id}")
    public Rim read(@PathVariable Long id) {
        return rimService.read(id);
    }

    @PutMapping("/update")
    public Rim update(@RequestBody Rim rim) {
        return rimService.update(rim);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return rimService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Rim> getAll() {
        return rimService.getAll();
    }
}