package com.example.demo.services;

import com.example.demo.dto.GenreDto;
import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDto> findAll() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genre -> new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getGenreUrl(),
                genre.toFilmsDto()
        )).collect(Collectors.toList());
    }

    @Override
    public Optional<GenreDto> findById(Long id) {
        Optional<Genre> genres = genreRepository.findById(id);
        return genres.map(genre -> new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getGenreUrl(),
                genre.toFilmsDto()
        ));
    }
}
