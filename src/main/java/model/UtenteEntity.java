package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "UTENTI")
@Table(name = "UTENTE")
public class UtenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name="seq", initialValue=100)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator= "seq")

	private long id;
	
	private String nome;
	private String password;
	private String email;
	private String username;

	@ManyToMany
	@JoinTable(
	  name = "gioco_utente", 
	  joinColumns = @JoinColumn(name = "fk_utente"), 
	  inverseJoinColumns = @JoinColumn(name = "fk_gioco"))
	private Set<GiochiEntity>giochi;

	public Set<GiochiEntity> getGiochi() {
		return giochi;
	}

	public void setGiochi(Set<GiochiEntity> giochi) {
		this.giochi = giochi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UtenteEntity [id=" + id + ", nome=" + nome + ", password=" + password + ", email=" + email
				+ ", username=" + username + "]";
	}

	

	
}