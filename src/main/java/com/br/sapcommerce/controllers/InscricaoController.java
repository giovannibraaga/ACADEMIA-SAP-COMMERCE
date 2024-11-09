package com.br.sapcommerce.controllers;

import com.br.sapcommerce.dto.AlunoDTO;
import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.dto.InscricaoDTO;
import com.br.sapcommerce.services.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<Void> assignAlunoToCurso(@RequestBody InscricaoDTO inscricaoDTO) {
        inscricaoService.assignAlunoToCurso(inscricaoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<CursoDTO>> findCursosByAlunoId(@PathVariable Long alunoId) {
        List<CursoDTO> cursosList = inscricaoService.findCursosByAlunoId(alunoId);
        return ResponseEntity.ok(cursosList);
    }

    @GetMapping("/cursos/{cursoId}")
    public ResponseEntity<List<AlunoDTO>> getAlunosByCursoId(@PathVariable Long cursoId) {
        List<AlunoDTO> alunosList = inscricaoService.getAlunosByCursoId(cursoId);
        return ResponseEntity.ok(alunosList);
    }

}
