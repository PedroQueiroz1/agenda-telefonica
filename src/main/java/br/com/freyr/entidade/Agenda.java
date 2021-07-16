package br.com.freyr.entidade;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome", nullable = false, length=50)
	@NotBlank(message="Nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;
	
	@Column(name="telefone",nullable = false, length=20)
	@NotBlank(message="Telefone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
	private String telefone;
	
	@Embedded
	private Endereco endereco;


	public Agenda() {
	}

	public Agenda(String nome, String telefone, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
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

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, codigo, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
}
