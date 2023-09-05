package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Animal;
import com.apicomsqlite.poo.service.AnimalService;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createanimal", method = RequestMethod.POST)
    public String createanimal(@RequestBody Animal animal) {
        return animalService.createanimal(animal);
    }

    @RequestMapping(value = "readanimais", method = RequestMethod.GET)
    public List<Animal> readanimais() {
        return animalService.readanimals();
    }

    @RequestMapping(value = "updateanimal", method = RequestMethod.PUT)
    public String updateanimal(@RequestBody Animal animal) {
        return animalService.updateanimal(animal);
    }

    @RequestMapping(value = "deleteanimal", method = RequestMethod.DELETE)
    public String deleteanimal(@RequestBody Animal animal) {
        return animalService.deleteanimal(animal);
    }
}
