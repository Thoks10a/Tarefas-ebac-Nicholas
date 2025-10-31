package br.com.ebac.animal_service.controllers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.repositorios.AnimalRepository;



@RestController
@RequestMapping("/animais")
public class AnimalController {
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return animalRepository.findByRaca("Siamês");
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return animalRepository.findNotAdopted();
    }

    @GetMapping("/quantity-animals-by-employees")
    private List<Object[]> quantityAnimalsByAllEmployees() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("01/01/2025");
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = dateFormat2.parse("31/12/2025");
        long time2 = date2.getTime();
        Timestamp timestamp2 = new Timestamp(time2);
        
        return animalRepository.quantityAnimalsByAllEmployees(timestamp, timestamp2);
    }

    

}
