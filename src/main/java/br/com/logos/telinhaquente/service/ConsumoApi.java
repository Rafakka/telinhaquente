package br.com.logos.telinhaquente.service;

import br.com.logos.telinhaquente.config.OmdbProperties;
import br.com.logos.telinhaquente.model.DadosDeMidia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class ConsumoApi {

    @Autowired
    private OmdbProperties omdbProperties;

    @Autowired
    private WebClient webClient;

    public DadosDeMidia obterDados(String titulo) {
        try {
            // Chamada à API usando WebClient
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                        .queryParam("t", titulo)
                        .queryParam("apikey", omdbProperties.getKey())
                        .build())
                    .retrieve()
                    .bodyToMono(DadosDeMidia.class)
                    .block();  // ← Esse .block() transforma o Mono em um objeto sincrônico
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Erro da API OMDb: " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da API: " + e.getMessage(), e);
        }
    }
}
