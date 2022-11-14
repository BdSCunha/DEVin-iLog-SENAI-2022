package tech.devinhouse.loja_util.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.loja_util.models.Venda;
import tech.devinhouse.loja_util.services.VendaService;

import java.util.List;

@RestController
@RequestMapping(path = "venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> get() {
        return vendaService.findAll();
    }

    @PostMapping
    public Venda post(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @PutMapping
    public Venda put(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @PutMapping(path = "{id}")
    public Venda put(@PathVariable Integer id, @RequestBody Venda venda) {
        venda.setId(id);
        return vendaService.save(venda);
    }

    @DeleteMapping
    public Boolean delete(Integer id) {
        return vendaService.remove(id);
    }
}
