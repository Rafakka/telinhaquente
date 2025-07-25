package br.com.logos.telinhaquente;

import br.com.logos.telinhaquente.config.OmdbProperties;
import br.com.logos.telinhaquente.model.DadosDeMidia;
import br.com.logos.telinhaquente.service.ConsumoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties(OmdbProperties.class)
public class TelinhaquenteApplication { 
    public static void main(String[] args) {
        SpringApplication.run(TelinhaquenteApplication.class, args);

    }
}
