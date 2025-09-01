package io.github.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.app.domain.paciente.Paciente;
import io.github.app.dto.PacienteDTO;

import io.github.app.dto.PacienteUpdateDTO;
import io.github.app.mapper.PacienteMapper;
import io.github.app.service.PacienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	private final PacienteService pacienteService;
	private final PacienteMapper pacienteMapper;

	public PacienteController(PacienteService pacienteService,
			PacienteMapper pacienteMapper) {
		this.pacienteService = pacienteService;
		this.pacienteMapper = pacienteMapper;
	}

	@GetMapping
	public ResponseEntity<Page<PacienteUpdateDTO>> index(
			@PageableDefault(sort = {"nome"}, size = 10) Pageable pageable) {
		var dtos = pacienteService.findAll(pageable)
				.map(m -> pacienteMapper.toPacienteUpdateDTO(m));
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteUpdateDTO> show(@PathVariable Long id) {
		var paciente = pacienteService.findById(id);
		var dto = pacienteMapper.toPacienteUpdateDTO(paciente);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	private ResponseEntity<PacienteUpdateDTO> create(
			@Valid @RequestBody PacienteDTO dto, UriComponentsBuilder builder) {
		Paciente paciente = pacienteService.create(dto);
		var uri = builder.path("/pacientes/{id}")
				.buildAndExpand(paciente.getId()).toUri();
		PacienteUpdateDTO listagemDTO = pacienteMapper
				.toPacienteUpdateDTO(paciente);
		return ResponseEntity.created(uri).body(listagemDTO);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PacienteUpdateDTO> update(@PathVariable Long id,
			@RequestBody PacienteUpdateDTO dto) {
		var paciente = pacienteService.updateById(id,dto);
		dto = pacienteMapper.toPacienteUpdateDTO(paciente);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
	}

}
