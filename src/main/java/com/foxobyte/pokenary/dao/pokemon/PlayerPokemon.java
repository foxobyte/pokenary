package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.constants.Status;
import com.foxobyte.pokenary.dao.Player;
//import com.foxobyte.pokenary.dao.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "player_pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPokemon implements IPokemon {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Pokemon pokemon;
    @OneToOne
    private Player player;
    private Integer level;
//    @ManyToOne(targetEntity = Move.class)
//    private Set<Move> moves;
    @OneToOne
    private IndividualValues individualValues;
    @OneToOne
    private DeterminantValues determinantValues;
    @ElementCollection
    private Map<Status, PokemonStatus> statuses;
    @OneToOne
    private EffortValues effortValues;
    @OneToOne
    private StatsExperience statsExperience;
//    @OneToOne
//    private Item heldItem;
//    @ElementCollection
//    private Map<Status, Integer> status;
    private Nature nature;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

//    public void addMove(Move move) {
//        if (this.moves == null) this.moves = new HashSet<>();
//        this.moves.add(move);
//    }

//    public void addStatus(Status status, Integer duration) {
//        if (this.status == null) this.status = new HashMap<>();
//        this.status.put(status, duration);
//    }

    public void setPokemon() {

    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    @Override
    @JsonIgnore
    public EffortValues getEffortValues() {
        return new EffortValues(0L, 1, 1, 1, 1, 1, 1);
    }

    public Map<Status, PokemonStatus> getStatuses() {
        return new HashMap<>();
    }

//    @JsonIgnore
//    public BasePokemon getBasePokemon() {
//        return this.basePokemon;
//    }
}
