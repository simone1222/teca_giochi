package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity()
@Table(name = "GIOCO")
public class GiochiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private Date dataUscita;
	
	@ManyToOne()
	private GenereEntity genere;
	
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataUscita() {
		return dataUscita;
	}
	public void setDataUscita(Date dataUscita) {
		this.dataUscita = dataUscita;
	}
	public GenereEntity getGenere() {
		return genere;
	}
	public void setGenere(GenereEntity genere) {
		this.genere = genere;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
