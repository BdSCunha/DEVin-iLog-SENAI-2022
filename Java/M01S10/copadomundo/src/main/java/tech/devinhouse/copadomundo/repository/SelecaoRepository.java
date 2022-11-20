package tech.devinhouse.copadomundo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.devinhouse.copadomundo.model.Selecao;

import java.util.List;

@Repository
public class SelecaoRepository extends JpaRepository<Selecao, String> {
//    @Query("SELECT s FROM Selecao WHERE s.sigla = :sigla")
//    List<Selecao> findSelecaoBySigla(@Param("selecao") String sigla);
}
