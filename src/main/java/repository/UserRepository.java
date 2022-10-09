package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.UtenteEntity;
//Ebbene, questo è quasi tutto il codice di cui abbiamo bisogno per implementare il data access layer.
//Questa interfaccia serve a disaccoppiare il business/service layer dal repository/DAO layer.
//Come si vede, con Spring Data JPA, NON è necessario scrivere alcun codice DAO. Basta infatti dichiarare un'interfaccia
//che estenda l'interfaccia CrudRepository, che definisce metodi CRUD come save(), findAll(),
//findById(), deleteById(), ecc. A tempo di esecuzione, Spring Data JPA penserà poi a generare
//automaticamente il codice di implementazione.
//Si noti che, quando si estende l'interfaccia CrudRepository, è necessario specificare il tipo della classe del model
//gestito dal DAO e il tipo della proprietà della chiave primaria: CrudRepository<Customer,Long>.


//Infine, implementiamo la funzione di ricerca che consente all'utente di cercare dei customer, digitando una parola 
//chiave. Siccome la funzione di ricerca cerca le parole chiave corrispondenti in uno dei tre campi name, email o 
//address, è necessario aggiungere all'interfaccia CustomerRepository il seguente metodo custom
public interface UserRepository extends CrudRepository<UtenteEntity, Long> {
@Query(value = "SELECT c FROM UTENTI c WHERE c.nome LIKE '%' || :keyword || '%'" +
" OR c.email LIKE '%' || :keyword || '%'" +
" OR c.username LIKE '%' || :keyword || '%'")
public List<UtenteEntity> search(@Param("keyword") String keyword);

public UtenteEntity getByUsername(String username);
//@Query(value="SELECT count(u) FROM UTENTI u WHERE u.username = :username and u.password=:password")
//public int isLogged(@Param("username") String username, @Param("password") String password);



}


