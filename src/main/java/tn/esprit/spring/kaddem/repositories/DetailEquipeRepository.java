package tn.esprit.spring.kaddem.repositories;

import tn.esprit.spring.kaddem.entities.DetailEquipe;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DetailEquipeRepository extends CrudRepository<DetailEquipe, Integer>{

}