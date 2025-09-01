package io.github.app.dto;

import io.github.app.domain.medico.Especialidade;
import io.github.app.domain.medico.Medico;

public record MedicoListagemDTO(String nome, String email, String crm, Especialidade especialidade) {
	public MedicoListagemDTO(Medico med) {
		this(med.getNome(),med.getEmail(),med.getCrm(),med.getEspecialidade());
		
	}
}
