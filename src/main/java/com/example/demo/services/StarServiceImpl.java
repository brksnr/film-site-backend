package com.example.demo.services;

import com.example.demo.dto.StarDto;
import com.example.demo.entity.Star;
import com.example.demo.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StarServiceImpl implements com.example.demo.services.StarService {

    private final StarRepository starRepository;


    @Autowired
    public StarServiceImpl(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    @Override
    public List<StarDto> getAllStarsWithFilms() {
        List<Star> stars = starRepository.findAllWithFilms();
        return stars.stream()
                .map(star -> new StarDto(
                        star.getId(),
                        star.getFullName(),
                        star.getAge(),
                        star.getWhoIs(),
                        star.toFilmsDto(),
                        star.getStarImg()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StarDto> findById(Long id) {
        Optional<Star> star = starRepository.findById(id);
        return star.map(st -> new StarDto(
                st.getId(),
                st.getFullName(),
                st.getAge(),
                st.getWhoIs(),
                st.toFilmsDto(),
                st.getStarImg()
        ));
    }

}
