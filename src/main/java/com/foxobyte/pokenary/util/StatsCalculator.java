package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.dao.pokemon.DeterminantValues;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;

import java.util.Random;

/**
 * @link <a href="https://bulbapedia.bulbagarden.net/wiki/Individual_values">Bulbapedia</a>
 * */
public class StatsCalculator {
    private static int leastSignificantBitMask = 1;

    public static IPokemon calculatePokemonStatsWithDeterminantValues(IPokemon pokemon) {
        pokemon.setHp(calculatePokemonHpGen1And2(pokemon.getPokemon().getHp(), pokemon.getDeterminantValues().getHp(), pokemon.getStatExperience().getHp(), pokemon.getLevel()));
        pokemon.setAttack(calculatePokemonStatGen1And2(pokemon.getPokemon().getAttack(), pokemon.getDeterminantValues().getAttack(), pokemon.getStatExperience().getAttack(), pokemon.getLevel()));
        pokemon.setDefense(calculatePokemonStatGen1And2(pokemon.getPokemon().getDefense(), pokemon.getDeterminantValues().getDefense(), pokemon.getStatExperience().getDefense(), pokemon.getLevel()));
        pokemon.setSpecialAttack(calculatePokemonStatGen1And2(pokemon.getPokemon().getSpecialAttack(), pokemon.getDeterminantValues().getSpecialAttack(), pokemon.getStatExperience().getSpecialAttack(), pokemon.getLevel()));
        pokemon.setSpecialDefense(calculatePokemonStatGen1And2(pokemon.getPokemon().getSpecialDefense(), pokemon.getDeterminantValues().getSpecialDefense(), pokemon.getStatExperience().getSpecialDefense(), pokemon.getLevel()));
        pokemon.setSpeed(calculatePokemonStatGen1And2(pokemon.getPokemon().getSpeed(), pokemon.getDeterminantValues().getSpeed(), pokemon.getStatExperience().getSpeed(), pokemon.getLevel()));

        return pokemon;
    }

    /**
     * @param base          int value of the base hp stat
     * @param dv            int value of the determinant hp value
     * @param statExp       int value of the stat hp experience
     * @param level         int value of the level of the Pokémon
     * */
    public static int calculatePokemonHpGen1And2(int base, int dv, int statExp, int level) {
        // ToDo: Stat experience formula "mis-match"
        return (int) Math.floor(((((base + dv) * 2) + Math.floor(Math.ceil(Math.sqrt(statExp)) / 4)) * level) / 100) + level + 10;
    }

    /**
     * @param base          int value of the corresponding base stat
     * @param dv            int value of the corresponding determinant value
     * @param statExp       int value of the corresponding stat experience value
     * @param level         int value of the level of the Pokémon
     * */
    public static int calculatePokemonStatGen1And2(int base, int dv, int statExp, int level) {
        // ToDo: Stat experience formula "mis-match"
        return (int) Math.floor(((((base + dv) * 2) + Math.floor(Math.ceil(Math.sqrt(statExp)) / 4)) * level) / 100) + 5;
    }

    public static DeterminantValues convertIndividualValuesToDeterminantValues(IndividualValues individualValues) {
        int attack = individualValues.getAttack() / 2;
        int defense = individualValues.getDefense() / 2;
        int special = (individualValues.getSpecialAttack() + individualValues.getSpecialDefense()) / 4;
        int speed = individualValues.getSpeed() / 2;
        int hp = ((attack & leastSignificantBitMask) << 3) + ((defense & leastSignificantBitMask) << 2) + ((speed & leastSignificantBitMask) << 1) + (special & leastSignificantBitMask);

        return new DeterminantValues(0L, hp, attack, defense, special, special, speed);
    }

    public static IPokemon calculatePokemonStatsWithIndividualValues(IPokemon pokemon) {
        pokemon.setHp(calculatePokemonHPGeneration3Onward(pokemon.getPokemon().getHp(), pokemon.getIndividualValues().getHp(), pokemon.getEffortValues().getHp(), pokemon.getLevel()));
        pokemon.setAttack(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getAttack(), pokemon.getIndividualValues().getAttack(), pokemon.getEffortValues().getAttack(), pokemon.getLevel()));
        pokemon.setDefense(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getDefense(), pokemon.getIndividualValues().getDefense(), pokemon.getEffortValues().getDefense(), pokemon.getLevel()));
        pokemon.setSpecialAttack(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpecialAttack(), pokemon.getIndividualValues().getSpecialAttack(), pokemon.getEffortValues().getSpecialAttack(), pokemon.getLevel()));
        pokemon.setSpecialDefense(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpecialDefense(), pokemon.getIndividualValues().getSpecialDefense(), pokemon.getEffortValues().getSpecialDefense(), pokemon.getLevel()));
        pokemon.setSpeed(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpeed(), pokemon.getIndividualValues().getSpeed(), pokemon.getEffortValues().getSpeed(), pokemon.getLevel()));

        return pokemon.getNature().calculateNature(pokemon);
    }

    /**
     * @param base          int value of the corresponding base stat
     * @param iv            int value of the corresponding individual value
     * @param ev            int value of the corresponding effort value
     * @param level         int value of the level of the Pokémon
     * */
    public static int calculatePokemonStatGeneration3Onward(int base, int iv, int ev, int level) {
        float EV = (float) ev;
        return (int) Math.floor((((2 * base + iv + Math.floor(EV / 4)) * level) / 100) + 5);
    }

    /**
     * @param base          int value of the corresponding base stat
     * @param iv            int value of the corresponding individual value
     * @param ev            int value of the corresponding effort value
     * @param level         int value of the level of the Pokémon
     * */
    public static int calculatePokemonHPGeneration3Onward(int base, int iv, int ev, int level) {
        float EV = (float) ev;
        return (int) Math.floor(((2 * base + iv + Math.floor(EV / 4)) * level) / 100) + level + 10;
    }

    public static IndividualValues convertDeterminantValuesToIndividualValues(DeterminantValues determinantValues) {
        int hp = determinantValues.getHp() * 2 + 1;
        int attack = determinantValues.getAttack() * 2 + 1;
        int defense = determinantValues.getDefense() * 2 + 1;
        int specialAttack = determinantValues.getSpecialAttack() * 2 + 1;
        int specialDefense = determinantValues.getSpecialDefense() * 2 + 1;
        int speed = determinantValues.getSpeed() * 2 + 1;

        return new IndividualValues(0L, hp, attack, defense, specialAttack, specialDefense, speed);
    }
}
