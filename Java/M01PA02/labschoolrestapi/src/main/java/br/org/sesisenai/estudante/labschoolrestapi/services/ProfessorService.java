package br.org.sesisenai.estudante.labschoolrestapi.services;

import br.org.sesisenai.estudante.labschoolrestapi.models.Professor;
import br.org.sesisenai.estudante.labschoolrestapi.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepository professorRepository;

    public Iterable<Professor> findAll() { return professorRepository.findAll(); }

    @Transactional
    public Professor save(Professor professor) { return professorRepository.save(professor); }
}
