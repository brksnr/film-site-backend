package com.example.demo.entity;
import com.example.demo.dto.GenreDto;
import com.example.demo.dto.StarDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="films")
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="director")
    private String director;

    @Column(name="stars")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="movie_actor",
            inverseJoinColumns = @JoinColumn(name="star_id"),
            joinColumns = @JoinColumn(name="film_id"))
    private List<Star> stars;

    @Column(name="description")
    private String description;

    @Column(name="genre")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="genre_film",
            inverseJoinColumns = @JoinColumn(name="genre_id"),
            joinColumns = @JoinColumn(name="film_id"))
    private List<Genre> genre;

    @Column(name = "imdb_rank")
    private double imdbRank;

    @Column(name = "image_url")
    private String imageUrl;


    public List<StarDto> toStarsDto() {
        if (stars == null || stars.isEmpty()) {
            return Collections.emptyList();
        }
        return stars.stream()
                .map(star -> new StarDto(
                        star.getId(),
                        star.getFullName(),
                        star.getAge(),
                        star.getWhoIs(),
                        null,
                        star.getStarImg()
                ))
                .collect(Collectors.toList());
    }

    public List<GenreDto> toGenreDto(){
        return genre.stream().map(genre -> new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getGenreUrl(),
                null
        )).collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                ", genre=" + genre +
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

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
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
}
