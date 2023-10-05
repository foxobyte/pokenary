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
    private BasePokemon basePokemon;
    @OneToOne
    @JsonIgnore
    private Game game;
    private Integer level;
    @ElementCollection
    private Set<Move> moves;
    @OneToOne
    private IndividualValues individualValues;
    @ElementCollection
    private Map<Status, Integer> status;
    private Nature nature;
    private Integer hp = 0;
    private Integer attack = 0;
    private Integer defense = 0;
    private Integer specialAttack = 0;
    private Integer specialDefense = 0;
    private Integer speed = 0;

    @Override
    @JsonIgnore
    public EffortValues getEffortValues() {
        return new EffortValues(0L, 1, 1, 1, 1, 1, 1);
    }
}
