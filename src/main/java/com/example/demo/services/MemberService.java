package com.example.demo.service;


import com.example.demo.repisitory.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
