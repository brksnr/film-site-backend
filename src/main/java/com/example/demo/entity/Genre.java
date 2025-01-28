package com.example.demo.entity;

import com.example.demo.dto.FilmDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre_url")
    private String genreUrl;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="genre_film",
            inverseJoinColumns = @JoinColumn(name="film_id"),
            joinColumns = @JoinColumn(name="genre_id"))
    private List<Films> films;


    public List<FilmDto> toFilmsDto() {
        return films.stream()
                .map(film -> new FilmDto(
                        film.getId(),
                        film.getName(),
                        film.getDirector(),
                        film.getDescription(),
                        film.toGenreDto(),
                        film.getImdbRank(),
                        film.getImageUrl(),
                        null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", films=" + films +
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

    public String getGenreUrl() {
        return genreUrl;
    }

    public void setGenreUrl(String genreUrl) {
        this.genreUrl = genreUrl;
    }

    public List<Films> getFilms() {
        return films;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
    }
}
