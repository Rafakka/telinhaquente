package br.com.logos.telinhaquente.service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConsumoApi {
    
    private final WebClient webClient;
    
    public ConsumoApi(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.omdbapi.com").build();
    }
    
    public Mono<DadosDeMidia> obterDados(String titulo) {
        return webClient.get()
            .uri("/?apikey={apiKey}&t={titulo}", "sua_chave_aqui", titulo)
            .retrieve()
            .bodyToMono(DadosDeMidia.class);
    }
}