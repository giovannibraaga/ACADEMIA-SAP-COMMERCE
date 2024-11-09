package com.br.sapcommerce.services;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.dto.InscricaoDTO;
import com.br.sapcommerce.entities.Aluno;
import com.br.sapcommerce.entities.Curso;
import com.br.sapcommerce.entities.Inscricao;
import com.br.sapcommerce.repositories.AlunoRepository;
import com.br.sapcommerce.repositories.CursoRepository;
import com.br.sapcommerce.repositories.InscricaoRepository;
import com.br.sapcommerce.utils.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void assignAlunoToCurso(InscricaoDTO inscricaoDTO) {
        Aluno aluno = alunoRepository.findById(inscricaoDTO.getIdAluno()).orElseThrow(() -> new RuntimeException("Aluno não encontrado na base de dados."));
        Curso curso = cursoRepository.findById(inscricaoDTO.getIdCurso()).orElseThrow(() -> new RuntimeException("Curso não encontrado na base de dados."));
        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(new Date());
        inscricaoRepository.save(inscricao);
    }

    public List<CursoDTO> findCursosByAlunoId(Long idAluno) {
        List<Curso> cursos = inscricaoRepository.findCursosByAlunoId(idAluno);
        return cursos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }

    public List<AlunoDTO> getAlunosByCursoId(Long idCurso) {
        List<Aluno> alunos = inscricaoRepository.findAlunosByCursoId(idCurso);
        return alunos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }
}
