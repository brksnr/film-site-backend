package com.example.demo.services;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;

import java.util.List;
import java.util.Optional;


public interface FilmsService {

    List<FilmDto> findAll();
    Optional<FilmDto> findById(Long id);
    List<FilmDto> findByGenre(String genreName);
}