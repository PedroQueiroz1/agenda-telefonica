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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * Por ser um controller é necessário utilizar a anotação @RestController,
 * para sinalizar que é uma classe do Spring MVC. Realizando, automaticamente,
 * tudo o que a anotação @Controller é capaz de fazer.
 * 
 * @RequestMapping necessário para mapear a URL
 * URL: http://localhost:8080/agenda
 * 
 * Anotações do swagger utilizadas nessa classe:
 * - @Api
 * - @ApiOperation
 */

@Api(tags = "Agenda")
@RestController
@RequestMapping("/agenda")
public class AgendaControlador {
	
	@Autowired
	private AgendaServico agendaServico;
	
	@ApiOperation(value="Listar")
	@GetMapping
	public List<Agenda> listarTodos(){
		return agendaServico.listarTodos();
	}
	
	@ApiOperation(value="Listar por codigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<Agenda> buscarPorCodigo(@PathVariable Long codigo){
		Optional<Agenda> agenda =  agendaServico.buscarPorCodigo(codigo);		
		return agenda.isPresent()?ResponseEntity.ok(agenda.get()):ResponseEntity.notFound().build();
	}
	
	
}