package com.br.sapcommerce.repositories;

import com.br.sapcommerce.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
