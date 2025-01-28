package com.example.demo.services;

import com.example.demo.exceptions.ApiException;
import com.example.demo.memberEntity.Member;
import com.example.demo.memberEntity.Role;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.RoleRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {

    private MemberRepository memberRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private com.example.demo.services.JwtService jwtService;


    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, com.example.demo.services.JwtService jwtService) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }



    public Member register(String username,String email, String password){

        if (memberRepository.findUserByUsername(username).isPresent()) {
            throw new ApiException("Username is already taken.", HttpStatus.BAD_REQUEST);
        }

        if (memberRepository.findUserByEmail(email).isPresent()) {
            throw new ApiException("Email is already taken.", HttpStatus.BAD_REQUEST);
        }
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setAuthorities(roles);

        return memberRepository.save(member);
    }


    public Member login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findUserByEmail(email);
        if (!memberOptional.isPresent()) {
            throw new ApiException("User not found", HttpStatus.UNAUTHORIZED);
        }
        Member member = memberOptional.get();
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new ApiException("Invalid password", HttpStatus.UNAUTHORIZED);
        }
        return member;
    }



}
