package com.example.demo.controller;

import com.example.demo.entity.Films;
import com.example.demo.memberEntity.Member;
import com.example.demo.repository.FilmsRepository;
import com.example.demo.repository.FilmsRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FilmsRepository filmsRepository;


    @PostMapping("/{username}/favorites")
    public ResponseEntity<String> addFavoriteFilm(@PathVariable String username, @RequestParam Long filmId) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        if (memberOpt.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Optional<Films> filmOpt = filmsRepository.findById(filmId);
        if (filmOpt.isEmpty()) {
            return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);

        }

        Member member = memberOpt.get();
        Films film = filmOpt.get();


        member.getFavorites().add(film);
        memberRepository.save(member);

        return new ResponseEntity<>("Film added to favorites", HttpStatus.OK);
    }

    @GetMapping("/{username}/favorites")
    public ResponseEntity<?> getFavorites(@PathVariable String username) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        if (memberOpt.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Member member = memberOpt.get();
        return new ResponseEntity<>(member.getFavorites(), HttpStatus.OK);
    }

    // Kullanıcının favorisinden film çıkarma
    @DeleteMapping("/{username}/favorites")
    public ResponseEntity<String> removeFavoriteFilm(@PathVariable String username, @RequestParam Long filmId) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        if (memberOpt.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Optional<Films> filmOpt = filmsRepository.findById(filmId);
        if (filmOpt.isEmpty()) {
            return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);
        }

        Member member = memberOpt.get();
        Films film = filmOpt.get();

        // Filmi favorilerden çıkarma
        member.getFavorites().remove(film);
        memberRepository.save(member);

        return new ResponseEntity<>("Film removed from favorites", HttpStatus.OK);
    }
}
