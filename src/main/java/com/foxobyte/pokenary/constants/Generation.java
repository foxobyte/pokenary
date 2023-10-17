package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;

import java.util.List;
import java.util.Set;

import static com.foxobyte.pokenary.util.CriticalHitCalculator.checkIsCriticalHitGeneration1;
import static com.foxobyte.pokenary.util.DamageCalculator.calculateBaseDamageGeneration1;
import static com.foxobyte.pokenary.util.RNGCalculator.calculateRandomGeneration1To2;
import static com.foxobyte.pokenary.util.StatsCalculator.*;

public enum Generation implements IGeneration {
    ONE(1) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            // ToDo: Validate
            int attack = move.getCategory().equals(MoveCategory.PHYSICAL) ? attackingPokemon.getAttack() : attackingPokemon.getSpecialAttack();
            int defense = move.getCategory().equals(MoveCategory.PHYSICAL) ? defendingPokemon.getDefense() : defendingPokemon.getSpecialDefense();

            int critical = 1;
            if (checkIsCriticalHitGeneration1(attackingPokemon.getPokemon().getSpeed(), move.isHighCrit(), attackingPokemon.getStatuses().containsKey(Status.FOCUSED))) critical = 2;

            int damage = calculateBaseDamageGeneration1(attackingPokemon.getLevel(), critical, attack, defense, move.getPower());
            if (attackingPokemon.getPokemon().getType().contains(move.getType())) damage = damage + (int) ((float) damage / 2);

            List<Float> effectivenesses = defendingPokemon.getPokemon().getType().stream().map(type -> move.getType().getEffectiveness().get(type.ordinal())).toList();
            for (float effectiveness : effectivenesses) {
                damage = (int) Math.floor(damage * effectiveness);
            }
            float random = calculateRandomGeneration1To2();
            damage = (int) ((float) damage * random);

            return damage;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            calculatePokemonStatsWithDeterminantValues(pokemon);
            pokemon.setHp(calculatePokemonHpGen1And2(pokemon.getPokemon().getHp(), pokemon.getDeterminantValues().getHp(), pokemon.getStatExperience().getHp(), pokemon.getLevel()));
            return pokemon;
        }
    },
    TWO(2) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    THREE(3) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    FOUR(4) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    FIVE(5) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    SIX(6) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    SEVEN(7) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    EIGHT(8) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

        @Override
        public IPokemon calculatePokemonStats(IPokemon pokemon) {
            return pokemon;
        }
    },
    NINE(9) {
        @Override
        public int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game) {
            return 0;
        }

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
