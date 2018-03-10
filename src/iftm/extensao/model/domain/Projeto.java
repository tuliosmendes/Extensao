package iftm.extensao.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PROJETO")
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PROJETO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NM_PROJETO",length=255,nullable=false)
	private String nome;
	
	@Column(name="QT_HORAS",nullable=false)
	private Integer horas;
	
	@ManyToOne
	@JoinColumn(name="ID_AUTOR",referencedColumnName="ID_PESSOA")
	private Pessoa autor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIM")
	private Date dataFim;

	@ManyToMany
	@JoinTable(name="TB_PARTICIPANTE_PROJETO",
	           joinColumns= @JoinColumn(name="ID_PROJETO"),
	           inverseJoinColumns = @JoinColumn(name="ID_PARTICIPANTE"))
	private List<Pessoa> participantes;

	public Projeto() {
		super();	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public List<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Pessoa> participantes) {
		this.participantes = participantes;
	}

}


