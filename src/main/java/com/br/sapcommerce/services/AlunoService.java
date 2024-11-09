package com.br.sapcommerce.services;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.entities.Aluno;
import com.br.sapcommerce.repositories.AlunoRepository;
import com.br.sapcommerce.utils.InscricaoPopulator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public AlunoDTO createAluno(@Valid AlunoDTO alunoDTO) {
        Aluno aluno = InscricaoPopulator.toEntity(alunoDTO);
        aluno.setDataCadastro(new Date());
        aluno = alunoRepository.save(aluno);
        return InscricaoPopulator.toModel(aluno);
    }

    public List<AlunoDTO> alunosList() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(InscricaoPopulator::toModel).collect(Collectors.toList());
    }

    public AlunoDTO findAlunoById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado na base de dados"));
        return InscricaoPopulator.toModel(aluno);
    }

    @Transactional
    public AlunoDTO updateAluno(Long id, @Valid AlunoDTO alunoDTO) {
        Aluno alunoExistente = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException(("Aluno não encontrado na base de dados")));
        alunoExistente.setNome(alunoDTO.getNome());
        alunoExistente.setEmail(alunoDTO.getEmail());
        alunoRepository.save(alunoExistente);
        return InscricaoPopulator.toModel(alunoExistente);
    }

    @Transactional
    public void deleteAlunoById(Long id) {
        alunoRepository.deleteById(id);
    }
}
