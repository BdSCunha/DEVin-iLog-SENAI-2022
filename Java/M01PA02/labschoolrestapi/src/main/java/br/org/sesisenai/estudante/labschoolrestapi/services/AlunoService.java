package br.org.sesisenai.estudante.labschoolrestapi.services;

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

    public boolean existsAlunoByCodigo(Long codigo) {
        return alunoRepository.existsAlunoByCodigo(codigo);
    }

    public boolean existsAlunoByCpf(Long cpf) {
        return alunoRepository.existsAlunoByCpf(cpf);
    }

    public Iterable<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findAlunoByCodigo(Long codigo) {
        return alunoRepository.findAlunoByCodigo(codigo);
    }

    @Transactional
    public Aluno save(Aluno aluno) {
        alunoRepository.save(aluno);

        return aluno;
    }

    @Transactional
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }

//    @Override
//    public void deleteById(Long id) {
//        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
//        if(alunoOptional.isEmpty()) throw new IllegalArgumentException();
//
//        alunoRepository.deleteById(id);
//    }
//
//    @Override
//    public <S extends Aluno> S save(S aluno) {
//        alunoRepository.save(aluno);
//
//        return aluno;
//    }
//
//    @Override
//    public long count() {
//        return alunoRepository.count();
//    }

//    @Override
//    public void deleteAll() {
//
//    }
}
