package com.example.demo.service;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;
import com.example.demo.entity.Genre;
import com.example.demo.repisitory.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FilmsServiceImpl implements FilmsService {

    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmsServiceImpl(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    @Override
    public List<FilmDto> findAll() {
        List<Films> films = filmsRepository.findAll();
        return films.stream()
                .map(film -> new FilmDto(
                        film.getId(),
                        film.getName(),
                        film.getDirector(),
                        film.getDescription(),
                        film.toGenreDto(),
                        film.getImdbRank(),
                        film.getImageUrl(),
                        film.toStarsDto()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FilmDto> findById(Long id) {
        Optional<Films> film = filmsRepository.findById(id);
        return film.map(f -> new FilmDto(
                f.getId(),
                f.getName(),
                f.getDirector(),
                f.getDescription(),
                f.toGenreDto(),
                f.getImdbRank(),
                f.getImageUrl(),
                f.toStarsDto()
        ));
    }

    @Override
    public List<FilmDto> findByGenre(String genreName) {
        List<Films> films = filmsRepository.findByGenre(genreName);
        return films.stream()
                .map(film -> new FilmDto(
                        film.getId(),
                        film.getName(),
                        film.getDirector(),
                        film.getDescription(),
                        film.toGenreDto(),
                        film.getImdbRank(),
                        film.getImageUrl(),
                        film.toStarsDto()
                ))
                .collect(Collectors.toList());
    }
}

