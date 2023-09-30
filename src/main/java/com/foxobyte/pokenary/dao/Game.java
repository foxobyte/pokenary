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
    private Pokemon wildPokemon;
//    @ManyToOne
//    private List<Player> players;
    private Boolean hasStarted = false;

//    public void addPlayer(Player player) {
//        if (players.isEmpty()) players = new ArrayList<>();
//        players.add(player);
//    }
}
