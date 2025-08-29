package io.github.app.domain.endereco;

import java.util.Objects;

import io.github.app.dto.CreateEndereco;
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
	@Column(nullable = false)
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
	public Endereco(CreateEndereco dto) {
		this.logradouro = dto.logradouro();
		this.bairro = dto.bairro();
		this.cep = dto.cep();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.numero = dto.numero();
		this.complemento = dto.complemento();
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
	
	
}
