package br.com.logos.telinhaquente.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDeMidia(
    @JsonAlias("Title") String titulo,
    @JsonAlias("Year") String ano,
    @JsonAlias("Genre") String genero,
    @JsonAlias("Plot") String sinopse,
    @JsonAlias("Poster") String poster,
    @JsonAlias("totalSeasons") String totalDeTemporadas,
    @JsonAlias("imdbRating") String avaliacao
) {}
