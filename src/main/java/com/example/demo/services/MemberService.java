package com.example.demo.services;


import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Films;
import com.example.demo.memberEntity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findUserByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("User not valid!");
                    throw new UsernameNotFoundException("User not valid!");
                });
    }


    public void addFavoriteFilm(String username, Films film) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            member.getFavorites().add(film);
            memberRepository.save(member);
        }
    }


    public void removeFavoriteFilm(String username, Films film) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            member.getFavorites().remove(film);
            memberRepository.save(member);
        }
    }


    public List<FilmDto> getFavoriteFilms(String username) {
        Optional<Member> memberOpt = memberRepository.findUserByUsername(username);
        return memberOpt.map(Member::toFilmsDto).orElse(Collections.emptyList());
    }



}
