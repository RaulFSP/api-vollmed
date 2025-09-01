package io.github.app.mapper;

import org.springframework.stereotype.Component;

import io.github.app.domain.endereco.Endereco;
import io.github.app.domain.medico.Especialidade;
import io.github.app.domain.medico.Medico;
import io.github.app.dto.MedicoDTO;

@Component
public class MedicoMapper {

	private final EnderecoMapper enderecoMapper;

	public MedicoMapper(
			EnderecoMapper enderecoMapper) {
		this.enderecoMapper = enderecoMapper;
	}

	public Medico fromDto(MedicoDTO dto) {
		return Medico.builder().id(dto.id()).nome(dto.nome()).crm(dto.crm()).email(dto.email())
				.endereco(enderecoMapper.fromDto(dto.enderecoDto()))
				.especialidade(resolveEspecialidade(dto.especialidade())).telefone(dto.telefone())
				.ativo(dto.ativo())
				.build();
	}

	public Medico updateFromDto(MedicoDTO dto, Medico med, Endereco end) {
		return Medico.builder()
				.id(med.getId())
				.nome(dto.nome() == null ? med.getNome() : dto.nome())
				.crm(dto.crm() == null ? med.getCrm() : dto.crm())
				.email(dto.email() == null ? med.getEmail() : dto.email())
				.endereco(end)
				.especialidade(dto.especialidade() == null ? med.getEspecialidade() : resolveEspecialidade(dto.especialidade()))
				.telefone(dto.telefone() == null ? med.getTelefone() : dto.telefone())
				.ativo(dto.ativo() == null ? med.getAtivo() : dto.ativo())
				.version(med.getVersion())
				.build();
	}

	private Especialidade resolveEspecialidade(String value) {
		return Especialidade.valueOf(value.toUpperCase());
	}
}
