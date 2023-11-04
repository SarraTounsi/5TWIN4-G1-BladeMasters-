package tn.esprit.spring.kaddem.services;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;

@Slf4j
@AllArgsConstructor
@Service
public class DetailEquipeServiceImpl implements IDetailEquipeService{
	
	@Autowired
	DetailEquipeRepository detEquipRep;
	
	@Override
	public List<DetailEquipe> retrieveAllDetailEquipes() {
		// TODO Auto-generated method stub
		List<DetailEquipe> detailequipes = (List<DetailEquipe>) detEquipRep.findAll();
		return detailequipes;
	}

	@Override
	public DetailEquipe addDetailEquipe(DetailEquipe e) {
		// TODO Auto-generated method stub
		return detEquipRep.save(e);
	}

	@Override
	public DetailEquipe updateDetailEquipe(DetailEquipe e) {
		// TODO Auto-generated method stub
		return detEquipRep.save(e);
	}

	@Override
	public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
		// TODO Auto-generated method stub
		return detEquipRep.findById(idDetailEquipe).get();
	}

	@Override
	public void removeDetailEquipe(Integer idDetailEquipe) {
		// TODO Auto-generated method stub
		detEquipRep.deleteById(idDetailEquipe);
	}

}