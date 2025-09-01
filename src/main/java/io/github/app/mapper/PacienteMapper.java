package io.github.app.mapper;

import org.springframework.stereotype.Component;

import io.github.app.domain.endereco.Endereco;
import io.github.app.domain.paciente.Paciente;
import io.github.app.dto.PacienteDTO;
import io.github.app.dto.PacienteListagemDTO;
import io.github.app.dto.PacienteUpdateDTO;

@Component
public class PacienteMapper {

	private final EnderecoMapper enderecoMapper;
	
	
	public PacienteMapper(EnderecoMapper enderecoMapper) {
		this.enderecoMapper = enderecoMapper;
	}


	public Paciente fromDto(PacienteDTO dto) {
		return Paciente.build()
				.id(dto.id())
				.nome(dto.nome())
				.email(dto.email())
				.cpf(dto.cpf())
				.telefone(dto.telefone())
				.endereco(enderecoMapper.fromDto(dto.endereco()))
				.build();
	}
	
	public Paciente updateFromDto(PacienteDTO dto, Paciente paciente, Endereco end) {
		return Paciente.build()
				.id(paciente.getId())
				.nome(dto.nome() == null ?paciente.getNome() : dto.nome())
				.email(dto.email() == null ? paciente.getEmail():dto.email())
				.cpf(dto.cpf() == null ? paciente.getCpf():dto.cpf())
				.telefone(dto.telefone() == null ? paciente.getTelefone() : dto.telefone())
				.endereco(end)
				.version(paciente.getVersion())
				.build();
	}
	public Paciente updateFromUpdateDto(PacienteUpdateDTO dto, Paciente paciente, Endereco end) {
		return Paciente.build()
				.id(paciente.getId())
				.nome(dto.nome() == null ?paciente.getNome() : dto.nome())
				.email(dto.email() == null ? paciente.getEmail():dto.email())
				.cpf(paciente.getCpf())
				.telefone(dto.telefone() == null ? paciente.getTelefone() : dto.telefone())
				.endereco(end)
				.version(paciente.getVersion())
				.build();
	}
	public PacienteListagemDTO toPacienteListagemDTO(Paciente paciente) {
		PacienteListagemDTO dto = new PacienteListagemDTO(paciente.getNome(), paciente.getEmail());
		return dto;
	}
	public PacienteUpdateDTO toPacienteUpdateDTO(Paciente paciente) {
		PacienteUpdateDTO dto = new PacienteUpdateDTO(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), enderecoMapper.toEnderecoDto(paciente.getEndereco()));
		return dto;
	}
}
