package br.com.logos.telinhaquente.service;

import br.com.logos.telinhaquente.config.OmdbProperties;
import br.com.logos.telinhaquente.model.DadosDeMidia;
import br.com.logos.telinhaquente.model.RespostaApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoApi {

    @Autowired
    private OmdbProperties omdbProperties;

    public DadosDeMidia obterDados(String titulo) {
        String endereco = "http://www.omdbapi.com/?t=" + titulo.replace(" ", "+") + "&apikey=" + omdbProperties.getKey();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ObjectMapper mapper = new ObjectMapper();

            RespostaApi respostaApi = mapper.readValue(json, RespostaApi.class);

            if ("False".equalsIgnoreCase(respostaApi.getResponse())) {
                throw new RuntimeException("Erro da API OMDb: " + respostaApi.getError());
            }

            return mapper.readValue(json, DadosDeMidia.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage(), e);
        }
    }
}
