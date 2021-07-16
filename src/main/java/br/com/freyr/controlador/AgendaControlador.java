package br.com.freyr.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@ApiOperation(value="Listar pessoas",nickname="listarTodasAsPessoas")
	@GetMapping
	public List<AgendaResponseDTO> listarTodas(){
		return agendaServico.listarTodos().stream()
				.map(agenda->AgendaResponseDTO.converterParaAgendaDTO(agenda))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value="Listar pessoas por codigo", nickname="buscarPessoaPorCodigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<AgendaResponseDTO> listarPorCodigo(@PathVariable Long codigo){
		Optional<Agenda> agenda =  agendaServico.buscarPorCodigo(codigo);		
		return agenda.isPresent()?ResponseEntity
				.ok(AgendaResponseDTO.converterParaAgendaDTO(agenda.get()))
				:ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Salvar pessoa", nickname="salvarPessoa")
	@PostMapping
	public ResponseEntity<AgendaResponseDTO> salvar(@Valid @RequestBody AgendaRequestDTO agendaDTO){
		Agenda agendaSalva = agendaServico.salvar(agendaDTO.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(AgendaResponseDTO.converterParaAgendaDTO(agendaSalva));
	}
	
	@ApiOperation(value="Atualizar pessoa", nickname="atualizarPessoa")
	@PutMapping("/{codigo}")
	public ResponseEntity<AgendaResponseDTO> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody AgendaRequestDTO agenda){
		var atualizarAgenda = agendaServico.atualizar(codigo, agenda.converterParaEntidade());
		return ResponseEntity.ok(AgendaResponseDTO.converterParaAgendaDTO(atualizarAgenda));
	}
	
	@ApiOperation(value="Deletar pessoa", nickname="deletarPessoa")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{codigo}")
	public void deletar(@PathVariable(value = "codigo") Long codigo) {
		agendaServico.deletar(codigo);
	}
}