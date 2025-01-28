package com.example.demo.services;

import com.example.demo.dto.StarDto;

import java.util.List;
import java.util.Optional;

public interface StarService {

    public List<StarDto> getAllStarsWithFilms ();
    Optional<StarDto> findById(Long id);
}
