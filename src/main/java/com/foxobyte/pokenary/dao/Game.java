package com.foxobyte.pokenary.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(targetEntity = PlayerPokemon.class)
    private List<PlayerPokemon> playerPokemon;
    private Boolean hasStarted = false;

    public void addPlayer(PlayerPokemon playerPokemon) {
        if (this.playerPokemon == null) this.playerPokemon = new ArrayList<>();
        this.playerPokemon.add(playerPokemon);
    }
}
