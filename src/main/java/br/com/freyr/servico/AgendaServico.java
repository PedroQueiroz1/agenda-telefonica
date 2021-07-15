package br.com.freyr.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.freyr.entidade.Agenda;
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
	
}
