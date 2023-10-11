package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.*;
import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.item.TechnicalMachine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "base_pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonDeserialize(using = CustomerJsonDeserializer.class)
public class Pokemon {
    @Id
    @GeneratedValue
    @Column(name = "base_pokemon_id")
    private Integer pokemonId;
    @JsonAlias({"national_number"})
    private Integer nationalNumber;
    private Generation generation;
    private String name;
    @ElementCollection
    private Set<Type> type;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    @JsonAlias({"spAtk"})
    private Integer specialAttack;
    @JsonAlias({"spDef"})
    private Integer specialDefense;
    private Integer speed;
    /**
     * Key: Integer of moveId
     * Value: Level at which move is learned
     * */
    @ElementCollection
    @JsonAlias({"moves_learned_at_level"})
    private Map<Integer, Integer> movesLearnedAtLevel;
//    @ElementCollection
//    private Set<TechnicalMachine> movesLearnedByTM;

    public Pokemon(Pokemon pokemon) {
        this.pokemonId = pokemon.getPokemonId();
        this.nationalNumber = pokemon.getNationalNumber();
        this.name = pokemon.getName();
        this.type = pokemon.getType();
        this.hp = pokemon.getHp();
        this.attack = pokemon.getAttack();
        this.defense = pokemon.getDefense();
        this.specialAttack = pokemon.getSpecialAttack();
        this.specialDefense = pokemon.getSpecialDefense();
        this.speed = pokemon.getSpeed();
    }

    public Pokemon(Integer nationalNumber, String name, Set<Type> type, Integer hp, Integer attack, Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
        this.nationalNumber = nationalNumber;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
}
