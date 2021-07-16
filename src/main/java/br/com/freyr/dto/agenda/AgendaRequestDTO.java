package br.com.freyr.dto.agenda;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.freyr.entidade.Agenda;
import br.com.freyr.entidade.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Agenda requisição DTO")
public class AgendaRequestDTO {

	@ApiModelProperty(value="Nome")
	@NotBlank(message="Nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;
	
	@ApiModelProperty(value="Telefone")
	@NotBlank(message="Telefone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
	private String telefone;
	
	@ApiModelProperty(value="Endereço")
	@NotNull(message="Endereco")
	@Valid
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
