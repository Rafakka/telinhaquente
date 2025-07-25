package br.com.logos.telinhaquente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/midia")
public class MidiaController {
    
    private final ConsumoApi consumoApi;
    
    public MidiaController(ConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }
    
    @GetMapping
    public Mono<ResponseEntity<?>> buscarMidia(@RequestParam String t) {
        return consumoApi.obterDados(t)
            .map(ResponseEntity::ok)
            .onErrorResume(e -> Mono.just(
                ResponseEntity.badRequest().body("Erro ao buscar mídia: " + e.getMessage())
            ));
    }
}