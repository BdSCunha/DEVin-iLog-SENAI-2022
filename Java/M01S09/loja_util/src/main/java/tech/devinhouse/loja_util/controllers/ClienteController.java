package tech.devinhouse.loja_util.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.loja_util.models.Cliente;
import tech.devinhouse.loja_util.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> get() {
        return clienteService.findAll();
    }

    @PostMapping
    public Cliente post(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping
    public Cliente put(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping
    public Boolean delete(Integer id) {
        return clienteService.remove(id);
    }
}
