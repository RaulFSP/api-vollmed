package io.github.app.repository;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import io.github.app.mapper.PacienteMapper;

@SpringBootTest
class PacienteRepositoryTest {

	private final PacienteRepository repository;
	private final PacienteMapper pacienteMapper;
	
	


	public PacienteRepositoryTest(PacienteRepository repository,
			PacienteMapper pacienteMapper) {
		this.repository = repository;
		this.pacienteMapper = pacienteMapper;
	}




	@Test
	void test(@PageableDefault(sort = { "nome" }, size = 10) Pageable pageable) {
		var dtos = repository.findAll(pageable).map(m->pacienteMapper.toPacienteListagemDTO(m));
		dtos.forEach(System.out::println);
	}

}
