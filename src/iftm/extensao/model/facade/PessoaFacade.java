package iftm.extensao.model.facade;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import iftm.extensao.model.dao.PessoaDao;
import iftm.extensao.model.domain.Pessoa;

@WebService(serviceName="ws/pessoa")
public class PessoaFacade {
	
	@Inject
	private PessoaDao pessoaDao;
	
	@WebMethod(operationName="retornaTodasAsPessoas")
	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = pessoaDao.getPessoas();
		for (Pessoa p : pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	
	@WebMethod(operationName="retornaPessoaPorID")
	public Pessoa getPessoa(@WebParam(name="IdPessoa") Integer id) {
		
		Pessoa pessoa = new Pessoa();
		
		if (id == 1) {
			pessoa.setId(1);
			pessoa.setNome("Nicollas");
		} else {
			pessoa.setId(2);
			pessoa.setNome("Tulio");
		}
	
		return pessoa;
	}

}
