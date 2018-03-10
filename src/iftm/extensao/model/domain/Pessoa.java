package iftm.extensao.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PESSOA")
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PESSOA")
	private Integer id;
	
	@Column(name="NM_PESSOA",length=255,nullable=false)
	private String nome;
	
	@ManyToMany(mappedBy="participantes")
	private List<Projeto> participacoes;
	
	@OneToMany(mappedBy="autor")
	private List<Projeto> projetosAutor;

	public Pessoa() {
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

	public List<Projeto> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Projeto> participacoes) {
		this.participacoes = participacoes;
	}

	public List<Projeto> getProjetosAutor() {
		return projetosAutor;
	}

	public void setProjetosAutor(List<Projeto> projetosAutor) {
		this.projetosAutor = projetosAutor;
	}
	
	
	
	
	

}
