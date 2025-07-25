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

        Scanner scanner = new Scanner(System.in);
        ConsumoApi consumoApi = SpringApplication
        .run(TelinhaquenteApplication.class, args)
        .getBean(ConsumoApi.class);


        System.out.println("=== Telinha Quente CLI ===");
        System.out.println("Digite o nome do filme ou série (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando a aplicação. Até logo!");
                break;
            }

            try {
                    DadosDeMidia midia = consumoApi.obterDados(entrada);
                    System.out.println("\n--- Resultado ---");
                    System.out.println("Título: " + midia.titulo());
                    System.out.println("Total de Temporadas: " + midia.totalDeTemporadas());
                    System.out.println("Avaliação IMDB: " + midia.avaliacao());
                    System.out.println("------------------\n");
                } catch (RuntimeException e) {
                    System.out.println("Erro ao buscar dados: " + e.getMessage());
                }

        }

        scanner.close();
    }
}
