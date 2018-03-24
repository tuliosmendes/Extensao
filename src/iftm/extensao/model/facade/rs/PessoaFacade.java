package iftm.extensao.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iftm.extensao.model.dao.PessoaDao;
import iftm.extensao.model.domain.Pessoa;

@Path(value="/pessoa")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PessoaFacade {
	
	@Inject
	private PessoaDao pessoaDao;
	
	
	@GET
	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = pessoaDao.getPessoas();
		for (Pessoa p : pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	
	@GET
	@Path("/{id}")
	public Pessoa getPessoa(@PathParam("id") Integer id) {
		Pessoa p = pessoaDao.getPessoaId(id);
		p.setParticipacoes(null);
		p.setProjetosAutor(null);
		return p;
	}
	
	@DELETE
	@Path("/{id}")
	public void excluirPessoa(@PathParam("id") Integer id) {
		pessoaDao.excluirPessoa(id);
	}
	
	@POST
	public void salvarPessoa(Pessoa pessoa) {
		pessoaDao.salvarPessoa(pessoa);
	}
	
	@PUT
	public void atualizarPessoa(Pessoa pessoa) {
		pessoaDao.atualizarPessoa(pessoa);
	}
	
	
}
