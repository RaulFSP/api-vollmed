package io.github.app.dto;

public record CreatePaciente(String nome, String email, String telefone, String cpf, CreateEndereco endereco) {

}
