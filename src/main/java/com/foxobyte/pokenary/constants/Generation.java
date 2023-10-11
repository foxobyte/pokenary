package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;

import static com.foxobyte.pokenary.util.StatsCalculator.*;

public enum Generation implements IGeneration {
    ONE(1) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
//            pokemon.setHp(calculatePokemonHpGen1And2(pokemon.getPokemon().getHp(), pokemon.getIndividualValues().getHp()));
            return pokemon;
        }
    },
    TWO(2) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    THREE(3) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    FOUR(4) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    FIVE(5) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    SIX(6) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    SEVEN(7) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    EIGHT(8) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    NINE(9) {
        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    };

    private Integer generation;

    Generation(Integer generation) {
        this.generation = generation;
    }

    @JsonValue
    public Integer getGeneration() {
        return this.generation;
    }
}
