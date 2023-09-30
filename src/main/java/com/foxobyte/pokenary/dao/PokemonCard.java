package com.foxobyte.pokenary.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonCard {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer pokemonId;
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;
    private String fileName;
    private String fileType;
}
