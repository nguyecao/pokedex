package com.example.demo.pokemon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PokemonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PokemonRepository repository) {
        return args -> {
            Pokemon bulbasaur = new Pokemon(
                    1L,
                    "Bulbasaur",
                    new String[] {"Grass", "Poison"},
                    2L
            );
            Pokemon ivysaur = new Pokemon(
                    2L,
                    "Ivysaur",
                    new String[] {"Grass", "Poison"},
                    3L
            );
            Pokemon venusaur = new Pokemon(
                    3L,
                    "Venusaur",
                    new String[] {"Grass", "Poison"},
                    null
            );

            repository.saveAll(
                    List.of(bulbasaur, ivysaur, venusaur)
            );
        };
    }
}
