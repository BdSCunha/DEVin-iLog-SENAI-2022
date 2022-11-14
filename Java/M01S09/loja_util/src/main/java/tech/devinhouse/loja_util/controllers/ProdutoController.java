package tech.devinhouse.loja_util.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.loja_util.models.Produto;
import tech.devinhouse.loja_util.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping(path = "produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> get() {
        return produtoService.findAll();
    }

    @PostMapping
    public Produto post(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping
    public Produto put(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @DeleteMapping
    public Boolean delete(Integer id) {
        return produtoService.remove(id);
    }
}
