package com.br.sapcommerce.controllers;

import com.br.sapcommerce.dto.CursoDTO;
import com.br.sapcommerce.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        CursoDTO criarCurso = cursoService.createCurso(cursoDTO);
        return ResponseEntity.status(201).body(criarCurso);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getCursosList() {
        List<CursoDTO> cursosList = cursoService.cursoList();
        return ResponseEntity.ok(cursosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> findCursoById(@PathVariable Long id) {
        CursoDTO curso = cursoService.findCursoById(id);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
        CursoDTO updatedCurso = cursoService.updateCurso(id, cursoDTO);
        return ResponseEntity.ok(updatedCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCursoById(id);
        return ResponseEntity.noContent().build();
    }
}
