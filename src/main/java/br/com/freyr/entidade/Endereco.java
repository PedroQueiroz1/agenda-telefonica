package br.com.freyr.entidade;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class Endereco {

	@Column(name = "logradouro", nullable = false, length = 80)
	@Length(min=3, max = 80)
	@NotBlank(message="Logradouro")
	private String logradouro;
	
	@Column(name = "numero", nullable = false)
	@NotNull(message = "Número")
	private Integer numero;
	
	@Column(name = "complemento", length = 15)
	@Length(min=1, max = 15)
	private String complemento;
	
	@Column(name = "bairro", nullable = false, length = 50)
	@Length(min=3, max = 50)
	@NotBlank(message="Bairro")
	private String bairro;

	@Column(name = "cep", nullable = false)
	@NotBlank(message="CEP")
	@Pattern(regexp="[\\d]{5}-[\\d]{3}", message = "CEP")
	private String cep;

	@Column(name = "cidade", nullable = false, length = 50)
	@Length(min=3, max = 50)
	@NotBlank(message="Cidade")
	private String cidade;
	
	@Column(name = "estado", nullable = false, length = 50)
	@Length(min=3, max = 50)
	@NotBlank(message="Estado")
	private String estado;
	
	
	public Endereco() {
	}

	public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cep, String cidade,
			String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}
	
	
	
	
}
