package br.org.sesisenai.estudante.labschoolrestapi.repositories;

import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    boolean existsAlunoByCodigo(Long codigo);

    boolean existsAlunoByCpf(Long cpf);

    public Optional<Aluno> findAlunoByCodigo(Long codigo);

    void deleteAlunoByCodigo(Long codigo);
}
