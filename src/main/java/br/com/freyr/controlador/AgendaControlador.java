package br.com.freyr.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.freyr.dto.agenda.AgendaRequestDTO;
import br.com.freyr.dto.agenda.AgendaResponseDTO;
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
	
	@ApiOperation(value="Listar",nickname="listarTodasAgendas")
	@GetMapping
	public List<AgendaResponseDTO> listarTodas(){
		return agendaServico.listarTodos().stream()
				.map(agenda->AgendaResponseDTO.converterParaAgendaDTO(agenda))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value="Listar por codigo", nickname="buscarAgendaPorCodigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<AgendaResponseDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<Agenda> agenda =  agendaServico.buscarPorCodigo(codigo);		
		return agenda.isPresent()?ResponseEntity
				.ok(AgendaResponseDTO.converterParaAgendaDTO(agenda.get()))
				:ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Salvar")
	@PostMapping
	public ResponseEntity<AgendaResponseDTO> salvar(@Valid @RequestBody AgendaRequestDTO agenda){
		Agenda agendaSalva = agendaServico.salvar(agenda.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(AgendaResponseDTO.converterParaAgendaDTO(agendaSalva));
	}
	
	
}