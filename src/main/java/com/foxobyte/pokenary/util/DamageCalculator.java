package com.foxobyte.pokenary.util;

import java.util.Random;

/**
 * @link <a href="https://bulbapedia.bulbagarden.net/wiki/Damage">Bulbapedia</a>
 * */
public class DamageCalculator {
    private static Random random = new Random();

    /**
     * @param level level of the attacking pokemon
     * @param critical is 2 for a critical hit, and 1 if otherwise
     * @param attack attack stat of the attacking pokemon for physical category moves or
     *               special stat of the attacking pokemon for special category moves
     * @param defense defense stat of the defending pokemon for physical category moves or
     *                special stat of the defending pokemon for special category moves
     * @param stab Same Type Attack Bonus should equal 1.5 if the attacking pokemon's move type is the same as the attacking pokemon's type
     * @param type1 Float value of
     *              0.5 if not effective
     *              1 if normally effective
     *              2 super effective
     * @param type2 Float value of second typing
     *              0.5 if not effective
     *              1 if normally effective
     *              2 super effective
     * */
    public static Integer calculateDamageGeneration1(Integer level, Integer critical, Integer power, Integer attack, Integer defense, Float stab, Float type1, Float type2) {
        Float A = (float) attack;
        Float D = (float) defense;

        Float damage = ((((((2 * level * critical) / 5) + 2) * power * (A / D)) / 50) + 2) * stab * type1 * type2;
        Float variance = ((float) random.nextInt(39) + 217) / 255;
        Integer result = (int) (damage * variance);

        return result;
    }

    /**
     *
     * */
    public static Integer calculateDamageGeneration2(Integer level, Integer power, Integer attack, Integer defense, Float item, Integer critical, Integer tk) {
        Float A = (float) attack;
        Float D = (float) defense;

//        Float damage = (2 * level);
        return 0;
    }

    public static Integer calculateDamageGeneration5Onward(Integer level, Integer power, Integer attack, Integer defense) {
        Integer variance = 100 - random.nextInt(16);

        Integer damage = (int) Math.floor(((((((2 * level) / 5) + 2) * power * (attack / defense)) / 50) + 2) * variance);

        return damage;
    }
}
