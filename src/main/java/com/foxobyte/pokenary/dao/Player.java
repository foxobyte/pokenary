package com.foxobyte.pokenary.dao;

import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<PlayerPokemon> playerPokemon;

    public void addPokemon(PlayerPokemon playerPokemon) {
        if (this.playerPokemon == null) this.playerPokemon = new HashSet<>();
        this.playerPokemon.add(playerPokemon);
    }
}
