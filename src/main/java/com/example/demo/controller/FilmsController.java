package com.example.demo.controller;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;
import com.example.demo.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmsController {

    private final FilmsService filmsService;

    @Autowired
    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping
    public Page<FilmDto> findAllFilms(Pageable pageable) {
        return filmsService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> getFilmById(@PathVariable Long id) {
        return filmsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-genre")
    public List<FilmDto> getFilmsByGenre(@RequestParam String genre) {
        return filmsService.findByGenre(genre);
    }


}
