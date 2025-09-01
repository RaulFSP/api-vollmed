package io.github.app.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.app.domain.medico.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

public record MedicoDTO(

		Long id,
		@NotBlank(message = "Nome é obrigatório") String nome,
		@NotBlank(message = "Email é obrigatório")
		@Email(message = "Formato do email é inválido") String email,

		@NotBlank(message = "CRM é obrigatório")
		@Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido") String crm,
		@NotBlank(message = "Especialidade é obrigatória") String especialidade,
		@JsonProperty(value = "endereco")
		@JsonAlias(value = "endereco")
		@NotNull(message = "Dados do endereço são obrigatórios")
		@Valid EnderecoDTO enderecoDto,
		@NotBlank(message = "Telefone é obrigatório")

		String telefone,
		@NotNull Boolean ativo) {
	public MedicoDTO(Medico med) {
		this(med.getId(), med.getNome(), med.getEmail(), med.getCrm(),
				med.getEspecialidade().toString(),
				new EnderecoDTO(med.getEndereco()), med.getTelefone(),
				med.getAtivo());
	}

}
