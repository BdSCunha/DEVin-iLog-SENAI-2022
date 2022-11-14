package tech.devinhouse.loja_util.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.loja_util.models.Cliente;
import tech.devinhouse.loja_util.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean remove(Integer id) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if(cliente.isEmpty()) return false;
            clienteRepository.delete(cliente.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
