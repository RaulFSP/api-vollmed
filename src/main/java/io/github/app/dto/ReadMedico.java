package io.github.app.dto;

import io.github.app.domain.medico.Especialidade;
import io.github.app.domain.medico.Medico;

public record ReadMedico(Long id, String nome, String email, String crm, Especialidade especialidade,
		ReadEndereco endereco) {
public  ReadMedico(Medico med) {
	this(med.getId(),med.getNome(),med.getEmail(),med.getCrm(),med.getEspecialidade(), new ReadEndereco(med.getEndereco()) );
}
}
