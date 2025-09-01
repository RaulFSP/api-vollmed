package io.github.app.mapper;

import org.springframework.stereotype.Component;

import io.github.app.domain.endereco.Endereco;
import io.github.app.dto.EnderecoDTO;

@Component
public class EnderecoMapper {

	public Endereco fromDto(EnderecoDTO dto) {
		return Endereco.builder().id(dto.id()).bairro(dto.bairro())
				.cep(dto.cep()).cidade(dto.cidade())
				.complemento(dto.complemento()).logradouro(dto.logradouro())
				.numero(dto.numero()).uf(dto.uf()).build();
	}

	public Endereco updateFromDto(EnderecoDTO dto, Endereco end) {
		if (dto ==null) {
			return end;
		}
		return Endereco.builder().id(end.getId())
				.bairro(dto.bairro() == null ? end.getBairro() : dto.bairro())
				.cep(dto.cep() == null ? end.getCep() : dto.cep())
				.cidade(dto.cidade() == null ? end.getCidade() : dto.cidade())
				.complemento(dto.complemento() == null
						? end.getComplemento()
						: dto.complemento())
				.numero(dto.numero() == null ? end.getNumero() : dto.numero())
				.logradouro(dto.logradouro() == null
						? end.getLogradouro()
						: dto.logradouro())
				.uf(dto.uf() == null ? end.getUf() : dto.uf()).build();
	}
	public EnderecoDTO toEnderecoDto(Endereco end) {
		EnderecoDTO  dto = new EnderecoDTO(end);
		return dto;
	}
}
