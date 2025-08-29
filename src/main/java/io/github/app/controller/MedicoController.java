package io.github.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.app.domain.medico.Medico;
import io.github.app.dto.CreateMedico;
import io.github.app.dto.ReadMedico;
import io.github.app.repository.MedicoRepository;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {
	@Autowired
	private MedicoRepository medicoRepository;

	@PostMapping
	public ResponseEntity<ReadMedico> newMedico(@RequestBody CreateMedico dto) {
		var med = new ReadMedico(medicoRepository.save(new Medico(dto)));
		return ResponseEntity.status(HttpStatus.CREATED).body(med);
	}
}
