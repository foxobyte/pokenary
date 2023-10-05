package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.*;
import com.foxobyte.pokenary.constants.Type;
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
public class BasePokemon {
    @Id
    @GeneratedValue
    @Column(name = "base_pokemon_id")
    private Integer basePokemonId;
    @JsonAlias({"national_number"})
    private Integer nationalNumber;
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

    public BasePokemon(BasePokemon basePokemon) {
        this.basePokemonId = basePokemon.getBasePokemonId();
        this.nationalNumber = basePokemon.getNationalNumber();
        this.name = basePokemon.getName();
        this.type = basePokemon.getType();
        this.hp = basePokemon.getHp();
        this.attack = basePokemon.getAttack();
        this.defense = basePokemon.getDefense();
        this.specialAttack = basePokemon.getSpecialAttack();
        this.specialDefense = basePokemon.getSpecialDefense();
        this.speed = basePokemon.getSpeed();
    }
}
