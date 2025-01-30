package com.example.demo.services;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;
import com.example.demo.entity.Genre;
import com.example.demo.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<FilmDto> findAll(Pageable pageable) {
        Page<Films> films = filmsRepository.findAll(pageable);
        return films
                .map(film -> new FilmDto(
                        film.getId(),
                        film.getName(),
                        film.getDirector(),
                        film.getDescription(),
                        film.toGenreDto(),
                        film.getImdbRank(),
                        film.getImageUrl(),
                        film.toStarsDto()
                ));
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

