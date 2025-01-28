package com.example.demo.dto;

import com.example.demo.entity.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmDto {
    private long id;
    private String name;
    private String director;
    private String description;
    private List<GenreDto> genre;
    private double imdbRank;
    private String imageUrl;
    private List<StarDto> stars;

    public FilmDto(long id, String name, String director, String description, List<GenreDto> genre, double imdbRank, String imageUrl, List<StarDto> stars) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.description = description;
        this.genre = genre;
        this.imdbRank = imdbRank;
        this.imageUrl = imageUrl;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", imdbRank=" + imdbRank +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GenreDto> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreDto> genre) {
        this.genre = genre;
    }

    public double getImdbRank() {
        return imdbRank;
    }

    public void setImdbRank(double imdbRank) {
        this.imdbRank = imdbRank;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<StarDto> getStars() {
        return stars;
    }

    public void setStars(List<StarDto> stars) {
        this.stars = stars;
    }
}
