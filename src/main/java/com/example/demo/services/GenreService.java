package com.example.demo.service;

import com.example.demo.dto.GenreDto;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<GenreDto> findAll();
    Optional<GenreDto> findById(Long id);
}
