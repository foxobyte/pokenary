package com.foxobyte.pokenary.dao;

import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private WildPokemon wildPokemon;
    @ElementCollection
    private Set<PlayerPokemon> playerPokemon;
    private Boolean hasStarted = false;
    private String message;
    private PriorityQueue<Move> queue;

    public void addPlayerPokemon(PlayerPokemon playerPokemon) {
        if (this.playerPokemon == null) this.playerPokemon = new HashSet<>();
        this.playerPokemon.add(playerPokemon);
    }

    public Set<PlayerPokemon> getPlayerPokemon() {
        if (this.playerPokemon == null) return new HashSet<>();
        return playerPokemon;
    }
}
