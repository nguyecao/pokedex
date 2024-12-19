package com.example.demo.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    // SELECT * FROM pokemon WHERE id =
    // @Query("SELECT p from Pokemon p WHERE p.id = ?1")
    Optional<Pokemon> findPokemonById(Long id);

}
