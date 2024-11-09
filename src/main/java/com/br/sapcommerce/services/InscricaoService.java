package com.br.sapcommerce.services;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.entities.Aluno;
import com.br.sapcommerce.entities.Curso;
import com.br.sapcommerce.entities.Inscricao;
import com.br.sapcommerce.repositories.AlunoRepository;
import com.br.sapcommerce.repositories.CursoRepository;
import com.br.sapcommerce.repositories.InscricaoRepository;
import com.br.sapcommerce.utils.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void assignAlunoToCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado na base de dados."));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado na base de dados."));
        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(new Date());
        inscricaoRepository.save(inscricao);
    }

    public List<CursoDTO> findCursosByAlunoId(Long alunoId) {
        List<Curso> cursos = inscricaoRepository.findCursosByAlunoId(alunoId);
        return cursos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }

    public List<AlunoDTO> getAlunosByCursoId(Long cursoId) {
        List<Aluno> alunos = inscricaoRepository.findAlunosByCursoId(cursoId);
        return alunos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }
}
