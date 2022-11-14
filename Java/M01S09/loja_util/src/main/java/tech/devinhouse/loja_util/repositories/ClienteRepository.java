package tech.devinhouse.loja_util.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.loja_util.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
