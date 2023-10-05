package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;
import com.foxobyte.pokenary.dao.Move;

import static com.foxobyte.pokenary.util.PokemonCalculator.calculateDamage;

public enum MoveCategory implements IMoveCategory {
    PHYSICAL("Physical") {
        @Override
        public void move(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move) {
            Integer damage = calculateDamage(attackingPokemon.getLevel(), move.getPower(), attackingPokemon.getAttack(), defendingPokemon.getDefense());
            defendingPokemon.setHp(defendingPokemon.getHp() - damage);
        }
    },
    SPECIAL("Special") {
        @Override
        public void move(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move) {
            Integer damage = calculateDamage(attackingPokemon.getLevel(), move.getPower(), attackingPokemon.getSpecialAttack(), defendingPokemon.getSpecialDefense());
            defendingPokemon.setHp(defendingPokemon.getHp() - damage);
        }
    },
    STATUS("Status") {
        @Override
        public void move(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move) {

        }
    };

    private String name;

    MoveCategory(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
