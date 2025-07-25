package br.com.logos.telinhaquente.controller;

import br.com.logos.telinhaquente.model.DadosDeMidia;
import br.com.logos.telinhaquente.service.ConsumoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midia")
public class MidiaController {

    private final ConsumoApi consumoApi;

    public MidiaController(ConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }

    @GetMapping
    public Mono<DadosDeMidia> buscarMidia(@RequestParam String t) {
        return consumoApi.obterDados(t);
    }
}