package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "GIOCO")
@Getter
@Setter
public class GiochiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(name = "NOME")
	private String nome;
    @ManyToOne()
    @JoinColumn(name = "FK_GENERE")
    private GenereEntity genere;
    @Column(name = "DATA_USCITA")
    private Date dataUscita;

}
