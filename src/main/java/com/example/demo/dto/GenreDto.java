package com.example.demo.dto;

import com.example.demo.entity.Films;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class GenreDto {

    private long id;
    private String name;
    private String genreUrl;
    private List<FilmDto> films;

    public GenreDto(long id, String name,String genreUrl, List<FilmDto> films) {
        this.id = id;
        this.name = name;
        this.genreUrl = genreUrl;
        this.films = films;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenreUrl() {
        return genreUrl;
    }

    public void setGenreUrl(String genreUrl) {
        this.genreUrl = genreUrl;
    }

    public List<FilmDto> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDto> films) {
        this.films = films;
    }
}
