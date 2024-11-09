package com.br.sapcommerce.services;

import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.entities.Curso;
import com.br.sapcommerce.repositories.CursoRepository;
import com.br.sapcommerce.utils.InscricaoPopulator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public CursoDTO createCurso(@Valid CursoDTO cursoDTO) {
        Curso curso = InscricaoPopulator.toEntity(cursoDTO);
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCriacao(new Date());
        curso = cursoRepository.save(curso);
        return InscricaoPopulator.toModel(curso);
    }

    public List<CursoDTO> cursoList() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }

    public CursoDTO findCursoById(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado na base de dados."));
        return InscricaoPopulator.toModel(curso);
    }

    @Transactional
    public CursoDTO updateCurso(Long id, @Valid CursoDTO cursoDTO) {
        Curso cursoExistente = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado na base de dados."));
        cursoExistente.setNome(cursoDTO.getNome());
        cursoExistente.setDescricao(cursoDTO.getDescricao());
        cursoRepository.save(cursoExistente);
        return InscricaoPopulator.toModel(cursoExistente);
    }

    @Transactional
    public void deleteCursoById(Long id) {
        cursoRepository.deleteById(id);
    }
}
