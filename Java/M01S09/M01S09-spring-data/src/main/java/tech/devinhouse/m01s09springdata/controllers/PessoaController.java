package tech.devinhouse.m01s09springdata.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pessoa")
public class PessoaController {
    @GetMapping
    public String get() {
        return "Pessoa - funcionando!";
    }
}
