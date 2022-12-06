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

@RestController
@RequestMapping(path = "api/alunos")
@AllArgsConstructor
public class AlunoController {
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody @Valid AlunoDTO alunoDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(alunoDTO, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }
}
