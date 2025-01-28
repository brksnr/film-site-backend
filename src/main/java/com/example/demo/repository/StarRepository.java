package com.example.demo.repository;

import com.example.demo.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StarRepository extends JpaRepository<Star,Long> {

    @Query("SELECT s FROM Star s JOIN FETCH s.films")
    List<Star> findAllWithFilms();
}
