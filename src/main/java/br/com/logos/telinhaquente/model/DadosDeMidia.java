package br.com.logos.telinhaquente.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDeMidia(
	@JsonAlias("Title") String titulo,
	@JsonAlias("totalSeasons") int totalTemporadas,
	@JsonAlias("imbRating") String avaliacao,
	@JsonAlias("Ano") String Year
) {
}
