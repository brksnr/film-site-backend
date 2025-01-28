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
@Table(name="star")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private String age;

    @Column(name = "who_is")
    private String whoIs;

    @Column(name = "star_img")
    private String starImg;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="movie_actor",
            inverseJoinColumns = @JoinColumn(name="film_id"),
            joinColumns = @JoinColumn(name="star_id"))
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
        return "Star{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", whoIs='" + whoIs + '\'' +
                ", starImg='" + starImg + '\'' +
                ", films=" + films +
                '}';
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWhoIs() {
        return whoIs;
    }

    public void setWhoIs(String whoIs) {
        this.whoIs = whoIs;
    }

    public String getStarImg() {
        return starImg;
    }

    public void setStarImg(String starImg) {
        this.starImg = starImg;
    }

    public List<Films> getFilms() {
        return films;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
    }
}
