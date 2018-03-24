package iftm.extensao.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import iftm.extensao.model.domain.Pessoa;


public class PessoaDao {

	@PersistenceContext(unitName="ExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		Query query = entityManager.createQuery("from Pessoa");
		return query.getResultList();
	}
	
	public Pessoa getPessoaId(Integer id) {
		return entityManager.find(Pessoa.class, id);
	}

	@Transactional
	public void salvarPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

	@Transactional
	public void excluirPessoa(Integer id) {
		entityManager.remove(entityManager.getReference(Pessoa.class, id));
	}

	@Transactional
	public void atualizarPessoa(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.persist(pessoa);
	}
	
}
