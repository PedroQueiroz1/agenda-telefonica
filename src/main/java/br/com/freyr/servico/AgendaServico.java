package br.com.freyr.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.freyr.entidade.Agenda;
import br.com.freyr.excecao.RegraAgendaException;
import br.com.freyr.repositorio.AgendaRepositorio;

@Service
public class AgendaServico {
	
	@Autowired
	private AgendaRepositorio agendaRepositorio;
	
	public List<Agenda> listarTodos(){
		return agendaRepositorio.findAll();
	}
	
	public Optional<Agenda> buscarPorCodigo(Long codigo){
		return agendaRepositorio.findById(codigo);
	}
	
	public Agenda salvar(Agenda agenda) {
		verificarConteudoDuplicado(agenda);
		return agendaRepositorio.save(agenda);
	}

	public Agenda atualizar(Long codigo, Agenda agenda) {
		Agenda novaPessoa = verificarSeExiste(codigo);
		verificarConteudoDuplicado(agenda);
		BeanUtils.copyProperties(agenda, novaPessoa, "codigo");
		return agendaRepositorio.save(novaPessoa);
	}
	
	public void deletar(Long codigo) {
		agendaRepositorio.deleteById(codigo);
	}
	
	private void verificarConteudoDuplicado(Agenda agenda) {
		var pessoaNaAgenda = agendaRepositorio.findByNome(agenda.getNome());
		if(pessoaNaAgenda!=null && pessoaNaAgenda.getId()!=agenda.getId()) {
			throw new RegraAgendaException(String.format("A pessoa %s com código %s já está cadastrada",
					agenda.getNome().toUpperCase(),agenda.getId()));
		}
	}
	
	private Agenda verificarSeExiste(Long codigo) {
		Optional<Agenda> pessoa = buscarPorCodigo(codigo);
		if(pessoa.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa.get();
	}
	
}
