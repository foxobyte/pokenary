package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;

import java.util.List;
import java.util.Random;

public class PokemonCalculator {
    private static Random random = new Random();
    private static List<Nature> natures = List.of(Nature.values());

    public static Integer calculateDamage(Integer level, Integer power, Integer attack, Integer defense) {
//        Integer targets = 1;
//        Integer parentalBond = 1;
//        Integer weatherBonus = 1;
//        Integer glaiveRush = 1;
//        Integer critical
        Integer variance = 100 - random.nextInt(16);
//        Integer stab = 1;
//        Integer type = 1;
//        Integer burn = 1;

        Integer damage = (int) Math.floor(((((((2 * level) / 5) + 2) * power * (attack / defense)) / 50) + 2) * variance);

        return damage;
    }

//    private static boolean isCritical() {
//        Integer r = random.nextInt(256);
//    }

    public static Nature getRandomNature() {
        return natures.get(random.nextInt(natures.size()));
    }

    public static IndividualValues generateIndividualValues() {
        IndividualValues individualValues = new IndividualValues();
        individualValues.setHp(random.nextInt(32));
        individualValues.setAttack(random.nextInt(32));
        individualValues.setDefense(random.nextInt(32));
        individualValues.setSpecialAttack(random.nextInt(32));
        individualValues.setSpecialDefense(random.nextInt(32));
        individualValues.setSpeed(random.nextInt(32));

        return individualValues;
    }

    public static IPokemon calculatePokemonStats(IPokemon pokemon) {
        pokemon.setHp(calculateHP(pokemon.getBasePokemon().getHp(), pokemon.getIndividualValues().getHp(), pokemon.getEffortValues().getHp(), pokemon.getLevel()));
        pokemon.setAttack(calculateStat(pokemon.getBasePokemon().getAttack(), pokemon.getIndividualValues().getAttack(), pokemon.getEffortValues().getAttack(), pokemon.getLevel()));
        pokemon.setDefense(calculateStat(pokemon.getBasePokemon().getDefense(), pokemon.getIndividualValues().getDefense(), pokemon.getEffortValues().getDefense(), pokemon.getLevel()));
        pokemon.setSpecialAttack(calculateStat(pokemon.getBasePokemon().getSpecialAttack(), pokemon.getIndividualValues().getSpecialAttack(), pokemon.getEffortValues().getSpecialAttack(), pokemon.getLevel()));
        pokemon.setSpecialDefense(calculateStat(pokemon.getBasePokemon().getSpecialDefense(), pokemon.getIndividualValues().getSpecialDefense(), pokemon.getEffortValues().getSpecialDefense(), pokemon.getLevel()));
        pokemon.setSpeed(calculateStat(pokemon.getBasePokemon().getSpeed(), pokemon.getIndividualValues().getSpeed(), pokemon.getEffortValues().getSpeed(), pokemon.getLevel()));

        return pokemon.getNature().calculateNature(pokemon);
    }

    private static Integer calculateStat(Integer baseValue, Integer individualValue, Integer effortValue, Integer level) {
        Integer s = (int) Math.floor((((2 * baseValue + individualValue + Math.floor(effortValue / 4)) * level) / 100) + 5);

        return s;
    }

    private static Integer calculateHP(Integer baseValue, Integer individualValue, Integer effortValue, Integer level) {
        Integer hp = (int) Math.floor(((2 * baseValue + individualValue + Math.floor(effortValue / 4)) * level) / 100) + level + 10;

        return hp;
    }
}
