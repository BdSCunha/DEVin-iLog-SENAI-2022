package br.org.sesisenai.estudante.labschoolrestapi.services;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {
    private AlunoRepository alunoRepository;

    public boolean existsAlunoByCpf(Long cpf) {
        return alunoRepository.existsAlunoByCpf(cpf);
    }

    Optional<Aluno> findAlunoByCpf(Long cpf) { return alunoRepository.findAlunoByCpf(cpf); }

    public Iterable<Aluno> findAll() { return alunoRepository.findAll(); }

    public Optional<Aluno> findAlunoByCodigo(Long codigo) { return alunoRepository.findAlunoByCodigo(codigo); }

    public Iterable<Aluno> findAlunosBySituacao(Situacao situacao) {
        return alunoRepository.findAlunosBySituacao(situacao);
    }

    @Transactional
    public Aluno save(Aluno aluno) { return alunoRepository.save(aluno); }

    @Transactional
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
}
