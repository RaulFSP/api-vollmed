package io.github.app.domain.endereco;

import java.util.Objects;

import io.github.app.dto.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false, length = 2)
	private String uf;
	@Column(nullable = false)
	private String numero;
	@Column(nullable = false)
	private String complemento;

	public Endereco() {
	}

	public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String numero,
			String complemento) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Endereco(EnderecoDTO dto) {
		this.logradouro = dto.logradouro();
		this.bairro = dto.bairro();
		this.cep = dto.cep();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.numero = dto.numero();
		this.complemento = dto.complemento();
	}

	public Endereco(Builder builder) {
		this.id = builder.id;
		this.logradouro = builder.logradouro;
		this.bairro = builder.bairro;
		this.cep = builder.cep;
		this.cidade = builder.cidade;
		this.uf = builder.uf;
		this.numero = builder.numero;
		this.complemento = builder.complemento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cep=" + cep + ", cidade="
				+ cidade + ", uf=" + uf + ", numero=" + numero + ", complemento=" + complemento + "]";
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private Long id;
		private String logradouro;
		private String bairro;
		private String cep;
		private String cidade;
		private String uf;
		private String numero;
		private String complemento;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder logradouro(String logradouro) {
			this.logradouro = logradouro;
			return this;
		}

		public Builder bairro(String bairro) {
			this.bairro = bairro;
			return this;
		}

		public Builder cep(String cep) {
			this.cep = cep;
			return this;
		}

		public Builder cidade(String cidade) {
			this.cidade = cidade;
			return this;
		}

		public Builder uf(String uf) {
			this.uf = uf;
			return this;
		}

		public Builder numero(String numero) {
			this.numero = numero;
			return this;
		}

		public Builder complemento(String complemento) {
			this.complemento = complemento;
			return this;
		}

		public Endereco build() {
			return new Endereco(this);
		}

	}
}
