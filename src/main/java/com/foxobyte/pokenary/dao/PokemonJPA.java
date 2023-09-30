package com.foxobyte.pokenary.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon_jpa")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonJPA {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonAlias({"national_number"})
    private Integer nationalNumber;
    private String name;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    @JsonAlias({"spAttack", "spAtk"})
    private Integer specialAttack;
    @JsonAlias({"spDefense", "spDef"})
    private Integer specialDefense;
    private Integer speed;

    public PokemonJPA(Pokemon pokemon) {
        this.nationalNumber = pokemon.getNationalNumber();
        this.name = pokemon.getName();
        this.hp = pokemon.getHp();
        this.attack = pokemon.getAttack();
        this.defense = pokemon.getDefense();
        this.specialAttack = pokemon.getSpecialAttack();
        this.specialDefense = pokemon.getSpecialDefense();
        this.speed = pokemon.getSpeed();
    }
}
