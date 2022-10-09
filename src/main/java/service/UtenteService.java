package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.UtenteEntity;
import repository.UserRepository;

//Si noti che questa classe è stata annotata con l'annotazione @Transactional, per fare in modo che tutti i suoi
//metodi vengano intercettati da Spring Data JPA, ed inseriti nella gestione delle transazioni.
//Si noti anche che in questa classe è stata iniettata un'istanza di una classe che implementa l'interfaccia
//CustomerRepository:
//@Autowired CustomerRepository repo;
//Come per magia, anche se NON scriviamo alcun codice DAO, sarà poi Spring Data JPA a generare automaticamente
//un'implementazione di questa interfaccia, che poi inietterà nel service a tempo di esecuzione.
//Notare che tutti i metodi di questa classe implementano delle particolari operazioni CRUD, limitandosi semplicemente
//a delegare il compito ad uno specifico metodo un oggetto CustomerRepository.

@Service
@Transactional
public class UtenteService {
    @Autowired
    UserRepository repo;

    public UtenteEntity getUtente(String username) {
        return repo.getByUsername(username);
    }
    public boolean isLogged(UtenteEntity utente) {
        for (UtenteEntity entity : repo.findAll()) {
            if (entity.getUsername().equals(utente.getUsername())
                    && utente.getPassword().equals(entity.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void save(UtenteEntity utente) {
        repo.save(utente);
    }

    public List<UtenteEntity> listAll() {
        return (List<UtenteEntity>) repo.findAll();
    }

    public UtenteEntity get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<UtenteEntity> search(String keyword) {
        return repo.search(keyword);
    }

}