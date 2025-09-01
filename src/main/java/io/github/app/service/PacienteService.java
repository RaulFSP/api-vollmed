package io.github.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.app.domain.endereco.Endereco;
import io.github.app.domain.paciente.Paciente;
import io.github.app.dto.PacienteDTO;
import io.github.app.dto.PacienteUpdateDTO;
import io.github.app.mapper.EnderecoMapper;
import io.github.app.mapper.PacienteMapper;
import io.github.app.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	private final EnderecoMapper enderecoMapper;
	private final PacienteMapper pacienteMapper;

	public PacienteService(PacienteRepository pacienteRepository,
			EnderecoMapper enderecoMapper, PacienteMapper pacienteMapper) {
		this.pacienteRepository = pacienteRepository;
		this.enderecoMapper = enderecoMapper;
		this.pacienteMapper = pacienteMapper;
	}

	public Page<Paciente> findAll(Pageable pageable) {
		return pacienteRepository.findAll(pageable);
	}

	public Paciente findById(Long id) {
		return pacienteRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Paciente não encontrado"));
	}

	public Paciente create(PacienteDTO dto) {
		Paciente paciente = pacienteMapper.fromDto(dto);
		return pacienteRepository.save(paciente);
	}
	@Transactional
	public Paciente updateById(Long id, PacienteUpdateDTO dto) {
		Paciente paciente = pacienteRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Paciente não encontrado"));
		Endereco endFinal = null;
		if (dto.endereco() == null) {
			endFinal = paciente.getEndereco();
		}
		endFinal = enderecoMapper.updateFromDto(dto.endereco(),
				paciente.getEndereco());
		Paciente pacienteNovo = pacienteMapper.updateFromUpdateDto(dto,
				paciente, endFinal);
		return pacienteRepository.save(pacienteNovo);
	}
}
