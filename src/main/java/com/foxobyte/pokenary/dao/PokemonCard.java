package com.foxobyte.pokenary.dao;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_card")
public class PokemonCard {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer pokemonId;
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;
    private String imageType;
}
