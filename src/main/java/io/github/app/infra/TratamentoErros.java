package io.github.app.infra;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratamentoErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> tratar404(){
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErroMessageDTO>> tratar400(MethodArgumentNotValidException e){
		var errors = e.getFieldErrors();
		List<ErroMessageDTO> dtos = errors.stream().map(m->{return new ErroMessageDTO(m.getField(), m.getDefaultMessage());}).collect(Collectors.toList());
		return ResponseEntity.badRequest().body(dtos);
	} 
	
	private record ErroMessageDTO(String campo, String msg) {}
}
