package com.br.sapcommerce.utils;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.entities.Aluno;
import com.br.sapcommerce.entities.Curso;

public class InscricaoPopulator {
    public static AlunoDTO toModel(Aluno aluno) {
        if (aluno == null) return null;

        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getDataCadastro()
        );
    }

    public static Aluno toEntity(AlunoDTO alunoDTO) {
        if (alunoDTO == null) return null;
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setDataCadastro(alunoDTO.getDataCadastro());
        return aluno;
    }

    public static CursoDTO toModel(Curso curso) {
        if (curso == null) return null;
        return new CursoDTO(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getDataCriacao()
        );
    }

    public static Curso toEntity(CursoDTO cursoDTO) {
        if (cursoDTO == null) return null;
        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCriacao(cursoDTO.getDataCriacao());
        return curso;
    }
}
