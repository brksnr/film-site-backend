package com.example.demo.controller;

import com.example.demo.dto.StarDto;
import com.example.demo.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stars")
public class StarController {

    private final StarService starService;


    @Autowired
    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping
    public List<StarDto> getAllStarsWithFilms() {
        return starService.getAllStarsWithFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarDto> getFilmById(@PathVariable Long id) {
        return starService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
