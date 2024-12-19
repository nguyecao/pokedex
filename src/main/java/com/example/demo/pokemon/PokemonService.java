package com.example.demo.pokemon;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PokemonService {



    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
      return pokemonRepository.findAll();
    }

    public void addNewPokemon(Pokemon pokemon) {
        Optional<Pokemon> pokemonById = pokemonRepository
                .findPokemonById(pokemon.getId());
        if (pokemonById.isPresent()) {
            throw new IllegalStateException("id already exists");
        }
        pokemonRepository.save(pokemon);
    }

    public void deleteStudent(Long pokemonId) {
        boolean exists = pokemonRepository.existsById(pokemonId);
        if (!exists) {
            throw new IllegalStateException("pokemon with id " + pokemonId + " does not exist");
        }
        pokemonRepository.deleteById(pokemonId);
    }

    @Transactional
    public void updatePokemon(Long pokemonId, String name, String[] type, Long evolutionId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new IllegalStateException((
                        "pokemon with id " + pokemonId + " does not exist"
                        )));
        if (name != null && name.length() > 0 && !Objects.equals(pokemon.getName(), name)) {
            pokemon.setName(name);
        }

        if (evolutionId != null && !Objects.equals(pokemon.getEvolution(), evolutionId)) {
            pokemon.setEvolution(evolutionId);
        }

        if (type != null && (pokemon.getType() == null || !Arrays.equals(type, pokemon.getType()))) {
            pokemon.setType(type);
        }
    }
}
