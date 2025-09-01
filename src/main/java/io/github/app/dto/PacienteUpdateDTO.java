package io.github.app.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record PacienteUpdateDTO(String nome, String email, String telefone, 
		@JsonAlias(value = {"endereco"})
		EnderecoDTO endereco) {

}
