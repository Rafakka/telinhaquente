package br.com.logos.telinhaquente;

import br.com.logos.telinhaquente.model.DadosDeMidia;
import br.com.logos.telinhaquente.service.ConsumoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
@SpringBootApplication
public class TelinhaquenteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelinhaquenteApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        ConsumoApi consumoApi = new ConsumoApi();

        System.out.println("=== Telinha Quente CLI ===");
        System.out.println("Digite o nome do filme ou série (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando a aplicação. Até logo!");
                break;
            }

            String url = "http://www.omdbapi.com/?t=" + entrada.replace(" ", "+") + "&apikey=4f901358";

            try {
                DadosDeMidia midia = consumoApi.obterDados(url);
                System.out.println("\n--- Resultado ---");
                System.out.println("Título: " + midia.titulo());
                System.out.println("Total de Temporadas: " + midia.totalTemporadas());
                System.out.println("Avaliação IMDB: " + midia.avaliacao());
                System.out.println("------------------\n");
            } catch (Exception e) {
                System.out.println("Erro ao buscar dados: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
