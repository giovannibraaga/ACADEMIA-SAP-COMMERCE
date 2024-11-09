package com.br.sapcommerce.repositories;

import com.br.sapcommerce.entities.Aluno;
import com.br.sapcommerce.entities.Curso;
import com.br.sapcommerce.entities.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    @Query("select i.curso from Inscricao i where i.aluno.id = :alunoId")
    List<Curso> findCursosByAlunoId(@Param("alunoId") Long alunoId);

    @Query("select i.aluno from Inscricao i where i.curso.id = :cursoId")
    List<Aluno> findAlunosByCursoId(@Param("cursoId") Long cursoId);
}
