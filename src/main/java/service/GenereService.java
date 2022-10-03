package service;

import java.util.List;

import model.GenereEntity;
import repository.GenereRepository;

public class GenereService  {

	GenereRepository repo;
	
	public List<GenereEntity> listAllGen() {				
		return (List<GenereEntity>) repo.findAll();
	}
	
//	public List<GenereEntity> CercaGeneri(String gen) {
//		return repo.searchGenere(gen);
//	}
	
	public void saveGen(GenereEntity genere) {
		repo.save(genere);
	}
	
}
