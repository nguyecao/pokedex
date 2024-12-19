package com.example.demo.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pokemon")
public class PokemonController {


    private final PokemonService pokemonService;  // USING POKEMON SERVICE

    @Autowired
    public PokemonController(PokemonService pokemonService) {  // USING POKEMON SERVICE
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon() { // USING POKEMON ENTITY
        return pokemonService.getPokemon();
    }

    @PostMapping
    public void registerNewPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addNewPokemon(pokemon);
    }

    @DeleteMapping(path = "{pokemonId}")
    public void deletePokemon(@PathVariable("pokemonId") Long pokemonId) {
        pokemonService.deleteStudent(pokemonId);
    }

    @PutMapping(path = "{pokemonId}")
    public void updatePokemon(
            @PathVariable("pokemonId") Long pokemonId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String[] type,
            @RequestParam(required = false) Long evolutionId
    ) {
        pokemonService.updatePokemon(pokemonId, name, type, evolutionId);
    }

}
