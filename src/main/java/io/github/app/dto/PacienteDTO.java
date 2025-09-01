package io.github.app.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(
		Long id,
		@NotBlank @Length(min = 2) String nome,
		@NotBlank @Email String email,
		@NotBlank @Pattern(regexp = "\\d{11}") String cpf,
		@NotBlank String telefone,
		@Valid @JsonAlias(value = "endereco") EnderecoDTO endereco) {

}
