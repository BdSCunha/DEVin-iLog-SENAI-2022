package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import br.org.sesisenai.estudante.labschoolrestapi.services.PedagogoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor
public class PedagogoController {
    private PedagogoService pedagogoService;

    // RF08 - Consulta de Pedagogos
    @GetMapping
    public ResponseEntity<Iterable<Pedagogo>> findAllPedagogos() {
        return ResponseEntity.status(HttpStatus.OK).body(pedagogoService.findAll());
    }
}
