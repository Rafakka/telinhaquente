package br.com.logos.telinhaquente.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.logos.telinhaquente.model.DadosDeMidia;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados (String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
                
                try {
                    HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    ObjectMapper objectMapper = new ObjectMapper();
                    return mapper.readValue(json, DadosDeMidia.class);

                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage(), e);
                }
    }
}