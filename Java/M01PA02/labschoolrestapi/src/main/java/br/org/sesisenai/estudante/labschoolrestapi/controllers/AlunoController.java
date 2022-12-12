package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AlunoDTO;
import br.org.sesisenai.estudante.labschoolrestapi.dtos.SituacaoAlunoDTO;
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

    // RF02 - Cadastro de Aluno
    @PostMapping
    public ResponseEntity<Object> createAluno(@RequestBody @Valid AlunoDTO alunoDto) {
        if (alunoService.existsAlunoByCpf(alunoDto.getCpf())) return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado!");

        if (!ValidadorCPF.isValidCPF(alunoDto.getCpf().toString()))  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campo(s) inválido(s).");

        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    // RF03 - Atualização da Situação da Matrícula de Aluno
    @PutMapping("{codigo}")
    public ResponseEntity<Object> updateSituacaoAluno(@RequestBody @Valid SituacaoAlunoDTO situacaoAlunoDTO, @PathVariable Long codigo) {
        if (alunoService.findAlunoByCodigo(codigo).isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado / inexistente.");

        var aluno = alunoService.findAlunoByCodigo(codigo).get();
        BeanUtils.copyProperties(situacaoAlunoDTO, aluno);

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    // RF04 - Consulta de Alunos
    // Deve prever um query param opcional de filtrar o resultado da consulta pela Situação da Matrícula
    // Caso não seja informado o parâmetro de pesquisa, deve retornar todos os registros da base de dados
    @GetMapping
    public ResponseEntity<Iterable<Aluno>> findAllAlunos(@RequestParam(required = false) Situacao situacao) {
        if(situacao != null) return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAlunosBySituacao(situacao));

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    // RF05 - Consulta de Aluno pelo Código
    @GetMapping("{codigo}")
    public ResponseEntity findAlunoByCodigo(@PathVariable Long codigo) {
        Optional<Aluno> alunoOptional = alunoService.findAlunoByCodigo(codigo);

        if (alunoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado / inexistente.");

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAlunoByCodigo(codigo));
    }

    // RF06 - Exclusão de Aluno
    @DeleteMapping("{codigo}")
    public ResponseEntity deleteAluno(@PathVariable Long codigo) {
        Optional<Aluno> alunoOptional = alunoService.findAlunoByCodigo(codigo);

        if(alunoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado / inexistente.");

        alunoService.delete(alunoOptional.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário excluído com sucesso!");
    }
}
