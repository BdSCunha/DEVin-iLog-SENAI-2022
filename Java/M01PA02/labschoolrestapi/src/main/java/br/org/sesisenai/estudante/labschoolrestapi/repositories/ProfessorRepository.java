package br.org.sesisenai.estudante.labschoolrestapi.repositories;

import br.org.sesisenai.estudante.labschoolrestapi.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
