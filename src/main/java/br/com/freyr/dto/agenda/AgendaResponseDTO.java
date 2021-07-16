package br.com.freyr.dto.agenda;

import br.com.freyr.entidade.Agenda;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Agenda retorno DTO")
public class AgendaResponseDTO {

	@ApiModelProperty(value="código")
	private Long codigo;
	
	@ApiModelProperty(value="Nome")
	private String nome;
	
	@ApiModelProperty(value="Telefone")
	private String telefone;

	private EnderecoResponseDTO enderecoDTO;
	
	public AgendaResponseDTO() {
	}

	public AgendaResponseDTO(Long codigo, String nome, String telefone, EnderecoResponseDTO enderecoDTO) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.enderecoDTO = enderecoDTO;
	}

	public static AgendaResponseDTO converterParaAgendaDTO(Agenda agenda) {
		EnderecoResponseDTO endeDTO = new EnderecoResponseDTO(agenda.getEndereco().getLogradouro(),
				agenda.getEndereco().getNumero(),agenda.getEndereco().getComplemento(), 
				agenda.getEndereco().getBairro(),agenda.getEndereco().getCep(),
				agenda.getEndereco().getCidade(),agenda.getEndereco().getEstado());
		return new AgendaResponseDTO(agenda.getCodigo(),agenda.getNome(),agenda.getTelefone(),endeDTO);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setId(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public EnderecoResponseDTO getEnderecoDTO() {
		return enderecoDTO;
	}


	public void setEnderecoDTO(EnderecoResponseDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

}
