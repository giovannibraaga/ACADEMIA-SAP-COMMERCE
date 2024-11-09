package com.br.sapcommerce.repositories;

import com.br.sapcommerce.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
