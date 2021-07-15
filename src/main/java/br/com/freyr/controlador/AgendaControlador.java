package br.com.freyr.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.freyr.entidade.Agenda;
import br.com.freyr.servico.AgendaServico;

@RestController
@RequestMapping("/agenda")
public class AgendaControlador {
	
	@Autowired
	private AgendaServico agendaServico;
	
	@GetMapping
	public List<Agenda> listarTodos(){
		return agendaServico.listarTodos();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Agenda> buscarPorCodigo(@PathVariable Long codigo){
		
		Optional<Agenda> agenda =  agendaServico.buscarPorCodigo(codigo);
		
		return agenda.isPresent()?ResponseEntity.ok(agenda.get()):ResponseEntity.notFound().build();
	}
	
	
}
