package br.com.logos.telinhaquente.model;


import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosDeMidia(
	@JsonAlias("Title") String titulo,
	@JsonAlias("totalTemporadas") int totalTemporadas,
	@JsonAlias("avaliacao") String avaliacao
) {
}
