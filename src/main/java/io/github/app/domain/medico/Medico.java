package io.github.app.domain.medico;

import java.util.Objects;

import io.github.app.domain.endereco.Endereco;
import io.github.app.dto.CreateMedico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	public Medico() {
	}

	public Medico(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.especialidade = especialidade;
		this.endereco = endereco;
	}
	public Medico(CreateMedico dto) {
		this.nome = dto.nome();
		this.email = dto.email();
		this.crm =  dto.crm();
		this.especialidade =  Especialidade.valueOf( dto.especialidade().toUpperCase());
		this.endereco = new Endereco( dto.createEndereco());
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Medico other = (Medico) obj;
		return Objects.equals(id, other.id);
	}

}
