package com.foxobyte.pokenary.dao.pokemon;

import com.foxobyte.pokenary.constants.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon_status")
public class PokemonStatus {
    @Id
    private Long id;
    private Status status;
    private Integer duration;
}
