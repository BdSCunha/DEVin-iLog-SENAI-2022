package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AlunoDTO;
import br.org.sesisenai.estudante.labschoolrestapi.models.Pessoa;
import br.org.sesisenai.estudante.labschoolrestapi.services.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/pessoa")
@AllArgsConstructor
public class PessoaController {
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id) {
        if(!pessoaService.existsById(id)) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Pessoa> pessoaOptional = pessoaService.findById(id);
        if(pessoaOptional.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(id).get());
    }
}
