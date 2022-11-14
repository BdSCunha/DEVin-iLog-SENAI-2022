package tech.devinhouse.loja_util.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.loja_util.models.Venda;
import tech.devinhouse.loja_util.repositories.VendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public boolean remove(Integer id) {
        try {
            Optional<Venda> venda = vendaRepository.findById(id);
            if (venda.isEmpty()) return false;
            vendaRepository.delete(venda.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
