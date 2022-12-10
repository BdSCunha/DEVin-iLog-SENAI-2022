package br.org.sesisenai.estudante.labschoolrestapi.repositories;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedagogoRepository extends CrudRepository<Pedagogo, Long> {
}
