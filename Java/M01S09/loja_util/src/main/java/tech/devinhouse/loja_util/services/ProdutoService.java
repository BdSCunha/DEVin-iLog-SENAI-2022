package tech.devinhouse.loja_util.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.loja_util.models.Produto;
import tech.devinhouse.loja_util.repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public boolean remove(Integer id) {
        try {
            Optional<Produto> produto = produtoRepository.findById(id);
            if(produto.isEmpty()) return false;
            produtoRepository.delete(produto.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
