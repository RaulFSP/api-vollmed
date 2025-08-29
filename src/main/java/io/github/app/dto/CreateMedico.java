package io.github.app.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CreateMedico(String nome, String email, String crm, String especialidade, 
		@JsonAlias(value = {"endereco"})
		CreateEndereco createEndereco) {

}
