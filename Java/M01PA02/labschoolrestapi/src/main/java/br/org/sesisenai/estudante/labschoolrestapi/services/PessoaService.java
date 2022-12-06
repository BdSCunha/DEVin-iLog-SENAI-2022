package br.org.sesisenai.estudante.labschoolrestapi.services;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pessoa;
import br.org.sesisenai.estudante.labschoolrestapi.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public boolean existsById(Long id) {
        return pessoaRepository.existsById(id);
    }

    public List<Pessoa> findAll() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if(pessoaOptional.isEmpty()) throw new IllegalStateException();
        return pessoaOptional;
    }

    public Pessoa save(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public void delete(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if(pessoaOptional.isEmpty()) throw new IllegalStateException();
        pessoaRepository.deleteById(id);
    }

    public void deleteAll() {
        pessoaRepository.deleteAll();
    }
}
