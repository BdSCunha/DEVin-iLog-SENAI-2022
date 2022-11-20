package tech.devinhouse.copadomundo.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "selecoes")
@AllArgsConstructor
@Validated
public class SelecaoController {
}
