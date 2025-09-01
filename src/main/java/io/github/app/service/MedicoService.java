package io.github.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.app.domain.endereco.Endereco;
import io.github.app.domain.medico.Medico;
import io.github.app.dto.MedicoDTO;
import io.github.app.mapper.EnderecoMapper;
import io.github.app.mapper.MedicoMapper;
import io.github.app.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MedicoService {

	private final MedicoRepository medicoRepository;
	private final EnderecoMapper enderecoMapper;
	private final MedicoMapper medicoMapper;
	

	public MedicoService(
			MedicoRepository medicoRepository,
			EnderecoMapper enderecoMapper,
			MedicoMapper medicoMapper) {
		this.medicoRepository = medicoRepository;
		this.enderecoMapper = enderecoMapper;
		this.medicoMapper = medicoMapper;
	}

	public Page<Medico> findAll(Pageable pageable) {
		return medicoRepository.findAllByAtivoTrue(pageable);
	}

	public Medico create(MedicoDTO dto) {
		var medico = medicoMapper.fromDto(dto);
		return medicoRepository.save(medico);
	}

	@Transactional
	public Medico updateById(MedicoDTO dto, Long id) {
		Medico medico = medicoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("médico não encontrado!"));
		Endereco endFinal = null;
		if (dto.enderecoDto() == null) {
			endFinal = medico.getEndereco();
		} else {
			endFinal = enderecoMapper.updateFromDto(dto.enderecoDto(), medico.getEndereco());
		}
		var medicoUpdate = medicoMapper.updateFromDto(dto, medico, endFinal);
		return medicoRepository.save(medicoUpdate);
		

	}

	public Medico findById(Long id) {
		var medico = medicoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("médico não encontrado!"));
		return medico;
	}
	
	
	@Transactional
	public void desativar(Long id) {
		Medico medico = medicoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("médico não encontrado!"));
		medico.setAtivo(false);
		
	}
	@Transactional
	public void ativar(Long id) {
		Medico medico = medicoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("médico não encontrado!"));
		medico.setAtivo(true);
	}

}
