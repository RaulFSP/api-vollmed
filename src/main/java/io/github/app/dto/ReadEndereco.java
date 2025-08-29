package io.github.app.dto;

import io.github.app.domain.endereco.Endereco;

public record ReadEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String numero,
		String complemento) {

	public ReadEndereco(Endereco end) {
		this(end.getLogradouro(), end.getBairro(), end.getCep(), end.getCidade(), end.getUf(), end.getNumero(),
				end.getComplemento());
	}
}
