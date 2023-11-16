package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.*;
import com.foxobyte.pokenary.constants.EggGroup;
import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.constants.GrowthRate;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.item.TechnicalMachine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pokemon {
    @Id
    @GeneratedValue
    @Column(name = "pokemon_id")
    private Integer pokemonId;
    private Generation generation;
    private Integer nationalNumber;
    private String name;
    private String species;
    private String height;
    private String weight;
//    @Transient
//    private Object specialAbilities;
//    @Transient
//    private Object hiddenAbility;
    @ElementCollection
    private List<Type> type;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;
    private Integer catchRate;
    // ToDo: JPA Unique constraint i.e. only one unique value per pokemon... ?
    @OneToOne(cascade = CascadeType.ALL)
    private EVYield evYield;
    private Integer baseFriendship;
    private Integer baseExp;
    private GrowthRate growthRate;
    @ElementCollection
    private List<EggGroup> eggGroups;
    @Transient
    private Map<String, String> gender;
    private Integer eggCycles;
    /**
     * Key: Integer of moveId
     * Value: Level at which move is learned
     * */
    @ElementCollection
    private Map<Integer, Integer> movesLearnedAtLevel;
//    @Transient
//    private Object movesLearnedOnEvolution;
//    @Transient
//    private Object movesLearnedByEggs;
//    @Transient
//    private Object movesLearnedByTutor;
//    @Transient
//    private Object movesLearnedByTM;
//    @Transient
//    private Object evolutions;

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

    public Pokemon(Integer nationalNumber, String name, List<Type> type, Integer hp, Integer attack, Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
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
