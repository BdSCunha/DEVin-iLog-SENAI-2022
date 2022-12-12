package br.org.sesisenai.estudante.labschoolrestapi.services;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import br.org.sesisenai.estudante.labschoolrestapi.repositories.PedagogoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PedagogoService {
    private PedagogoRepository pedagogoRepository;

    public Iterable<Pedagogo> findAll() { return pedagogoRepository.findAll(); }

    public Optional<Pedagogo> findPedagogoByCodigo(Long codigo) { return pedagogoRepository.findPedagogoByCodigo(codigo); }

    @Transactional
    public Pedagogo save(Pedagogo professor) { return pedagogoRepository.save(professor); }
}
