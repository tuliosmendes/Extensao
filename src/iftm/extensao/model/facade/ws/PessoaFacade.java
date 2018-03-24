package iftm.extensao.model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

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
		Pessoa p = pessoaDao.getPessoaId(id);
		p.setParticipacoes(null);
		p.setProjetosAutor(null);
		return p;
	}
	
	
	@WebMethod(operationName="deletarPessoa")
	public void excluirPessoa(@PathParam("id") Integer id) {
		pessoaDao.excluirPessoa(id);
	}
	
	@WebMethod(operationName="salvarPessoa")
	public void salvarPessoa(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaDao.salvarPessoa(pessoa);
	}
	
	@WebMethod(operationName="atualizarPessoa")
	public void atualizarPessoa(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaDao.atualizarPessoa(pessoa);
	}
	

}
