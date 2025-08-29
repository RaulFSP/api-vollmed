package io.github.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.app.domain.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
