package br.com.logos.telinhaquente.service;

import br.com.logos.telinhaquente.model.RespostaApi;
import br.com.logos.telinhaquente.model.DadosDeMidia;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.management.RuntimeErrorException;

public class ConsumoApi {

    public DadosDeMidia obterDados (String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
                
                try {
                    HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    ObjectMapper mapper = new ObjectMapper();

                    RespostaApi respostaApi = mapper.readValue(json, RespostaApi.class);

                    if ("False".equalsIgnoreCase(respostaApi.getResponse())){
                        throw new RuntimeException("Erro na Api"+ respostaApi.getError());
                    }

                    return mapper.readValue(json, DadosDeMidia.class);

                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage(), e);
                }
    }
}