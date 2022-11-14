package tech.devinhouse.loja_util.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.loja_util.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
