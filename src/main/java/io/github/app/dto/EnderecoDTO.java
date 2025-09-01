package io.github.app.dto;

import io.github.app.domain.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
		Long id,
		@NotBlank String logradouro,
		@NotBlank String bairro,
		@NotBlank @Pattern(regexp = "\\d{8}") String cep,
		@NotBlank String cidade,
		@NotBlank String uf,
		String numero,
		String complemento) {
	public EnderecoDTO(
			Endereco end) {
		this(end.getId(), end.getLogradouro(), end.getBairro(), end.getCep(), end.getCidade(), end.getUf(),
				end.getNumero(), end.getComplemento());
	}
}
