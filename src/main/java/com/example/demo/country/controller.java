package com.example.demo.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class controller {

    @Autowired
    private repository countryRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<entity> get() {
        return countryRepository.findAll();
    }

    @PostMapping("/")
    public String post(@RequestBody entity entity) {
        countryRepository.save(entity);
        return "Hello from post";
    }

    @PutMapping("/")
    public String put(@RequestBody entity entity) {
        countryRepository.save(entity);
        return "Editado";
    }

    @DeleteMapping("/")
    public String delete(@RequestParam(name = "id", required = true) String id) {
        entity toDelete = new entity();
        Integer newId = Integer.parseInt(id);
        toDelete.setId(newId);

        countryRepository.delete(toDelete);

        return "Deleted";
    }
}
