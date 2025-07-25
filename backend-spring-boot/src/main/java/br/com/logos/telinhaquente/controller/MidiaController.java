package br.com.logos.telinhaquente.controller;

import br.com.logos.telinhaquente.model.DadosDeMidia;
import br.com.logos.telinhaquente.service.ConsumoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midia")
public class MidiaController {

    @Autowired
    private ConsumoApi consumoApi;

    @GetMapping
    public ResponseEntity<?> buscarMidia(@RequestParam("t") String titulo) {
        try {
            DadosDeMidia midia = consumoApi.obterDados(titulo);

            if (midia == null || midia.titulo() == null || midia.titulo().isBlank()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(midia);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro ao buscar mídia: " + e.getMessage());
        }
    }
}