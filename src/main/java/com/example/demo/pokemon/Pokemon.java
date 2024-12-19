package com.example.demo.pokemon;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table
public class Pokemon {

    @Id
    private Long id;
    private String name;
    private String[] type;
    private Long evolution;

    public Pokemon() {
    }

    public Pokemon(Long id, String name, String[] type, Long evolution) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.evolution = evolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public Long getEvolution() {
        return evolution;
    }

    public void setEvolution(Long evolution) {
        this.evolution = evolution;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + Arrays.toString(type) +
                ", evolution=" + evolution +
                '}';
    }
}
