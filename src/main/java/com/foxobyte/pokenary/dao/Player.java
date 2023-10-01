package com.foxobyte.pokenary.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(targetEntity = PlayerPokemon.class)
    private List<PlayerPokemon> pokemon;

    public void addPokemon(PlayerPokemon pokemon) {
        if (this.pokemon == null) this.pokemon = new ArrayList<>();
        this.pokemon.add(pokemon);
    }
}
