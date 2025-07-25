package br.com.logos.telinhaquente.service;

import br.com.logos.telinhaquente.config.OmdbProperties;
import br.com.logos.telinhaquente.model.DadosDeMidia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class ConsumoApi {

    @Autowired
    private OmdbProperties omdbProperties;

    @Autowired
    private WebClient webClient;

    public DadosDeMidia obterDados(String titulo) {
        try {
            Mono<DadosDeMidia> monoMidia = webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("t", titulo)
                            .queryParam("apikey", omdbProperties.getKey())
                            .build())
                    .retrieve()
                    .bodyToMono(DadosDeMidia.class);

            return monoMidia.block();  // Espera de forma síncrona a resposta
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Erro da API OMDb: " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da API: " + e.getMessage(), e);
        }
    }
}