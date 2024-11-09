package com.br.sapcommerce.controllers;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> createAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO aluno = alunoService.createAluno(alunoDTO);
        return ResponseEntity.status(201).body(aluno);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> alunosList() {
        List<AlunoDTO> listaAlunos = alunoService.alunosList();
        return ResponseEntity.ok().body(listaAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> findAlunoById(@PathVariable Long id) {
        AlunoDTO aluno = alunoService.findAlunoById(id);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> updateAluno(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoAtualizado = alunoService.updateAluno(id, alunoDTO);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAlunoById(id);
        return ResponseEntity.noContent().build();
    }
}
