package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AlunoDto;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.services.AlunoService;
import br.org.sesisenai.estudante.labschoolrestapi.utils.ValidadorCPF;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody @Valid AlunoDto alunoDto) {
        if(alunoService.existsAlunoByCpf(alunoDto.getCpf())) return ResponseEntity.status(HttpStatus.CONFLICT).build();

        if(!ValidadorCPF.isValidCPF(alunoDto.getCpf().toString())) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> findAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    @GetMapping("{codigo}")
    public ResponseEntity findAlunoByCodigo(@PathVariable Long codigo) {
        Optional<Aluno> alunoOptional = alunoService.findAlunoByCodigo(codigo);
        if(alunoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAlunoByCodigo(codigo));
    }

//    @PutMapping("{codigo}")
//    public ResponseEntity<Aluno> updateAluno(@RequestBody Situacao situacao, @PathVariable Long codigo) {
//        Optional<Aluno> alunoOptional = alunoService.findAlunoByCodigo(codigo);
//        if(alunoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        var aluno = new Aluno();
//        BeanUtils.copyProperties(alunoOptional, aluno);
//        aluno.setSituacao(situacao);
//
//        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
//    }

    @DeleteMapping("{codigo}")
    public ResponseEntity deleteAluno(@PathVariable Long codigo) {
        Optional<Aluno> alunoOptional = alunoService.findAlunoByCodigo(codigo);
        if(alunoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        alunoService.delete(alunoOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
