package br.com.guikapp.animal.abrigo_animais.repository;

import br.com.guikapp.animal.abrigo_animais.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByAdotado(boolean adotado);
}
