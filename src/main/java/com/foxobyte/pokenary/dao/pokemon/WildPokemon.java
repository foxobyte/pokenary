package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.constants.Status;
import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Move;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "wild_pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WildPokemon implements IPokemon {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JsonIgnore
    private Pokemon pokemon;
    @OneToOne
    @JsonIgnore
    private Game game;
    private Integer level;
    @ElementCollection
    private Set<Move> moves;
    @OneToOne
    private IndividualValues individualValues;
    @Transient
    private EffortValues effortValues;
    @OneToOne
    private DeterminantValues determinantValues;
    @Transient
    private StatExperience statExperience;
    @ElementCollection
    private Map<Status, PokemonStatus> statuses;
    private Nature nature;
    private Integer hp = 0;
    private Integer attack = 0;
    private Integer defense = 0;
    private Integer specialAttack = 0;
    private Integer specialDefense = 0;
    private Integer speed = 0;

    public WildPokemon(Pokemon pokemon, Integer level, DeterminantValues determinantValues, StatExperience statExperience) {
        this.pokemon = pokemon;
        this.level = level;
        this.determinantValues = determinantValues;
        this.statExperience = statExperience;
    }

    public WildPokemon(Pokemon pokemon, Integer level, IndividualValues individualValues, EffortValues effortValues, Nature nature) {
        this.pokemon = pokemon;
        this.level = level;
        this.individualValues = individualValues;
        this.effortValues = effortValues;
        this.nature = nature;
    }

    public void setPokemon() {

    }

    public Map<Status, PokemonStatus> getStatuses() {
        return new HashMap<>();
    }
}
