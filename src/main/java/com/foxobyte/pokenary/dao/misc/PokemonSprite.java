package com.foxobyte.pokenary.dao.misc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_sprites")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonSprite {
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