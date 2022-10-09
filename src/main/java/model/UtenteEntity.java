package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "UTENTI")
@Table(name = "UTENTE")
public class UtenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String password;
	private String email;
	private String username;
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "GIOCO_UTENTE", joinColumns = @JoinColumn(name = "FK_UTENTE"), inverseJoinColumns = @JoinColumn(name = "FK_GIOCO"))
    private List<GiochiEntity> giochi;



	

	
}