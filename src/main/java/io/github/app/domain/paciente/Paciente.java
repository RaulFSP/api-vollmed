package io.github.app.domain.paciente;

import io.github.app.domain.endereco.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	@Version
	private Long version;

	public Paciente() {
	}

	private Paciente(Builder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.email = builder.email;
		this.cpf = builder.cpf;
		this.telefone = builder.telefone;
		this.endereco = builder.endereco;
		this.version = builder.version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public static Builder build() {
		return new Builder();
	}
	
	public static class Builder {

		private Long id;
		private String nome;
		private String email;
		private String cpf;
		private String telefone;
		private Endereco endereco;
		private Long version;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
		public Builder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}
		public Builder endereco(Endereco endereco) {
			this.endereco = endereco;
			return this;
		}
		public Builder version(Long version) {
			this.version = version;
			return this;
		}
		public Paciente build() {
			return new Paciente(this);
		}
		
	}
}
