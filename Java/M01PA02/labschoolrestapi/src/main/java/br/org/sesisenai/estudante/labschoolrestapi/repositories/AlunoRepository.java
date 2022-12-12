package br.org.sesisenai.estudante.labschoolrestapi.repositories;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    boolean existsAlunoByCpf(Long cpf);

    Optional<Aluno> findAlunoByCodigo(Long codigo);

    Optional<Aluno> findAlunoByCpf(Long cpf);

    Iterable<Aluno> findAlunosBySituacao(Situacao situacao);
}
