package br.com.rsouza8891.buscaCep.controller;

import br.com.rsouza8891.buscaCep.model.CepResposta;
import br.com.rsouza8891.buscaCep.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepResposta> buscarCep(@PathVariable String cep) {
        CepResposta response = cepService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }

}
