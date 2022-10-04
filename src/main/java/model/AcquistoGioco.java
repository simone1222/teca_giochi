package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "ACQUISTOGIOCO")
public class AcquistoGioco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Acquisto;
	
	private String nome;
	private String email;
	private String indirizzo;
	private String password;
	
	@ManyToOne()
	private GiochiEntity giocoEntity;
	
	@ManyToOne()
	private UtenteEntity utenteEntiry;
	
	
	public long getId_Acquisto() {
		return Id_Acquisto;
	}
	public void setId_Acquisto(long id_Acquisto) {
		Id_Acquisto = id_Acquisto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
