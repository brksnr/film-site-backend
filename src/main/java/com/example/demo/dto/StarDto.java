package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.ALWAYS)
public class StarDto {
    private long id;
    private String fullName;
    private String age;
    private String whoIs;
    private String starImg;
    private List<FilmDto> films;

    public StarDto(long id, String fullName, String age, String whoIs, List<FilmDto> films, String starImg) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.whoIs = whoIs;
        this.films = films;
        this.starImg = starImg;
    }

    public List<FilmDto> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDto> films) {
        this.films = films;
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
}
