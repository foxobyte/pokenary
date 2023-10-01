package com.foxobyte.pokenary.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "player_pokemon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPokemon {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Pokemon pokemon;
    @OneToOne
    private Player player;
    private Integer level;
}
