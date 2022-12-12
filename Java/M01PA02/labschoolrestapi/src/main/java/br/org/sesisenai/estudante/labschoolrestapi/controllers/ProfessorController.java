package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.models.Professor;
import br.org.sesisenai.estudante.labschoolrestapi.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {
    private ProfessorService professorService;

    // RF07 - Consulta de Professores
    @GetMapping
    public ResponseEntity<Iterable<Professor>> findAllProfessores() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }
}
