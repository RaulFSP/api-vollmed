package io.github.app.controller;

import io.github.app.dto.MedicoDTO;
import io.github.app.dto.MedicoListagemDTO;
import io.github.app.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {
  private final MedicoService medicoService;

  public MedicoController(MedicoService medicoService) {
    this.medicoService = medicoService;
  }

  @GetMapping
  public ResponseEntity<Page<MedicoListagemDTO>> index(
    @PageableDefault(sort = { "crm" }, size = 10) Pageable pageable
  ) {
    var dtos = medicoService.findAll(pageable).map(MedicoListagemDTO::new);
    return ResponseEntity.status(HttpStatus.OK).body(dtos);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<MedicoListagemDTO> show(@PathVariable Long id) {
    var dto = new MedicoListagemDTO(medicoService.findById(id));
    return ResponseEntity.status(HttpStatus.OK).body(dto);
  }

  @PostMapping
  public ResponseEntity<MedicoDTO> newMedico(
    @Valid @RequestBody MedicoDTO dto,
    UriComponentsBuilder builder
  ) {
    dto = new MedicoDTO(medicoService.create(dto));
    var uri = builder.path("/medicos/{id}").buildAndExpand(dto.id()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<MedicoDTO> updateMedico(
    @PathVariable Long id,
    @RequestBody MedicoDTO dto
  ) {
    dto = new MedicoDTO(medicoService.updateById(dto, id));
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id) {
    medicoService.desativar(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Void> ativar(@PathVariable Long id) {
    medicoService.ativar(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
