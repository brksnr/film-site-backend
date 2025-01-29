package com.example.demo.repository;

import com.example.demo.entity.Films;
import com.example.demo.memberEntity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findUserByEmail(String email);

    @Query("SELECT m FROM Member m WHERE m.username = :username")
    Optional<Member> findUserByUsername(String username);

    @Query("SELECT m.favorites FROM Member m WHERE m.username = :username")
    Optional<Set<Films>> findFavoritesByUsername(String username);
}
