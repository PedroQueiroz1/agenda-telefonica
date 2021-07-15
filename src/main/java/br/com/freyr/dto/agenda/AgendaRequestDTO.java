package br.com.freyr.dto.agenda;

import br.com.freyr.entidade.Agenda;
import br.com.freyr.entidade.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente requesição DTO")
public class AgendaRequestDTO {

	@ApiModelProperty(value="Nome")
	private String nome;
	
	@ApiModelProperty(value="Telefone")
	private String telefone;
	
	@ApiModelProperty(value="Endereço")
	private EnderecoRequestDTO enderecoDTO;

	public Agenda converterParaEntidade() {
		var endereco = new Endereco(enderecoDTO.getLogradouro(),
				enderecoDTO.getNumero(),enderecoDTO.getComplemento(),
				enderecoDTO.getBairro(),enderecoDTO.getCep(),
				enderecoDTO.getCidade(),enderecoDTO.getEstado()); 
		return new Agenda(nome,telefone,endereco);
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

	public EnderecoRequestDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoRequestDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}
	
	
	
}
