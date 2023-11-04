package tn.esprit.spring.kaddem.services;

import java.util.List;

import tn.esprit.spring.kaddem.entities.DetailEquipe;

public interface IDetailEquipeService {
	List<DetailEquipe> retrieveAllDetailEquipes();
	DetailEquipe addDetailEquipe(DetailEquipe e);
	DetailEquipe updateDetailEquipe(DetailEquipe e);
	DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe);
	void removeDetailEquipe(Integer idDetailEquipe);

}