package com.example.demo.repository;

import com.example.demo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    @Query("SELECT g FROM Genre g JOIN FETCH g.films WHERE g.id = :genreId")
    List<Genre> findFilmsByGenreId(Long genreId);
}
