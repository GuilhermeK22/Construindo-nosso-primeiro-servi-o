package br.com.guikapp.animal.abrigo_animais.controller;

import br.com.guikapp.animal.abrigo_animais.model.Animal;
import br.com.guikapp.animal.abrigo_animais.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
    @GetMapping("/adotados")
    public List<Animal> getAdoptedAnimals() {
        return animalRepository.findByAdotado(true);
    }
    @GetMapping("/nao-adotados")
    public List<Animal> getNonAdoptedAnimals() {
        return animalRepository.findByAdotado(false);
    }
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
        Animal animal = animalRepository.findById(id).orElse(null);
        if (animal != null) {
            animal.setNome(animalDetails.getNome());
            animal.setEspecie(animalDetails.getEspecie());
            animal.setAdotado(animalDetails.isAdotado());
            return animalRepository.save(animal);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }
}
