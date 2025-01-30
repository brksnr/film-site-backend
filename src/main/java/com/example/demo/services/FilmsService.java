package com.example.demo.services;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface FilmsService {

    Page<FilmDto> findAll(Pageable pageable);
    Optional<FilmDto> findById(Long id);
    List<FilmDto> findByGenre(String genreName);
}