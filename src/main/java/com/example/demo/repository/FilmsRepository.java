package com.example.demo.repository;

import com.example.demo.entity.Films;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;



public interface FilmsRepository extends JpaRepository<Films,Long> {

    @Query("SELECT f FROM Films f JOIN FETCH f.stars")
    Page<Films> findAllFilms(Pageable pageable);

    @Query("SELECT f FROM Films f JOIN f.genre g WHERE g.name = :genreName")
    List<Films> findByGenre(@Param("genreName") String genreName);


}
