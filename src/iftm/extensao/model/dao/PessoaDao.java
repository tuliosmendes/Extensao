package iftm.extensao.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import iftm.extensao.model.domain.Pessoa;


public class PessoaDao {

	@PersistenceContext(unitName="ExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		Query query = entityManager.createQuery("from Pessoa");
		return query.getResultList();
	}
	
}
