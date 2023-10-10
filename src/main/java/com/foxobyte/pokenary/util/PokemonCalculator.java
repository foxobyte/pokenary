package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;

import java.util.Random;

public class PokemonCalculator {
    private static Random random = new Random();


    public static IPokemon calculatePokemonStats(IPokemon pokemon) {
        pokemon.setHp(calculatePokemonHPGeneration3Onward(pokemon.getPokemon().getHp(), pokemon.getIndividualValues().getHp(), pokemon.getEffortValues().getHp(), pokemon.getLevel()));
        pokemon.setAttack(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getAttack(), pokemon.getIndividualValues().getAttack(), pokemon.getEffortValues().getAttack(), pokemon.getLevel()));
        pokemon.setDefense(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getDefense(), pokemon.getIndividualValues().getDefense(), pokemon.getEffortValues().getDefense(), pokemon.getLevel()));
        pokemon.setSpecialAttack(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpecialAttack(), pokemon.getIndividualValues().getSpecialAttack(), pokemon.getEffortValues().getSpecialAttack(), pokemon.getLevel()));
        pokemon.setSpecialDefense(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpecialDefense(), pokemon.getIndividualValues().getSpecialDefense(), pokemon.getEffortValues().getSpecialDefense(), pokemon.getLevel()));
        pokemon.setSpeed(calculatePokemonStatGeneration3Onward(pokemon.getPokemon().getSpeed(), pokemon.getIndividualValues().getSpeed(), pokemon.getEffortValues().getSpeed(), pokemon.getLevel()));

        return pokemon.getNature().calculateNature(pokemon);
    }

    public static Integer calculatePokemonStatGen1And2(Integer baseValue, Integer individualValue, Integer exp, Integer level) {
        Integer s = (int) Math.floor(((baseValue + individualValue) * 2 + Math.floor(Math.floor(Math.sqrt(exp) / 4)) * level) / 100) + 5;

        return s;
    }

    public static Integer calculatePokemonHpGen1And2(Integer baseValue, Integer individualValue, Integer exp, Integer level) {
        Integer s = (int) Math.floor((((baseValue + individualValue) * 2 + Math.floor(Math.floor(Math.sqrt(exp) / 4))) * level) / 100) + level + 10;

        return s;
    }

    public static Integer calculatePokemonStatGeneration3Onward(Integer baseValue, Integer individualValue, Integer effortValue, Integer level) {
        Integer s = (int) Math.floor((((2 * baseValue + individualValue + Math.floor(effortValue / 4)) * level) / 100) + 5);

        return s;
    }

    public static Integer calculatePokemonHPGeneration3Onward(Integer baseValue, Integer individualValue, Integer effortValue, Integer level) {
        Integer hp = (int) Math.floor(((2 * baseValue + individualValue + Math.floor(effortValue / 4)) * level) / 100) + level + 10;

        return hp;
    }
}
