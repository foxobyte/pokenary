package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.dao.pokemon.DeterminantValues;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;

import java.util.List;
import java.util.Random;

public class RNGCalculator {
    private static Random random = new Random();
    private static int leastSignificantBitMask = 1;
    private static List<Nature> natures = List.of(Nature.values());

    public RNGCalculator(Random random) {
        this.random = random;
    }

    public static Nature getRandomNature() {
        return natures.get(random.nextInt(natures.size()));
    }

    public static float calculateRandomGeneration1To2() {
        return ((float) random.nextInt(38) + 217) / 255;
    }

    public static DeterminantValues generateDeterminantValues() {
        int attack = random.nextInt(16);
        int defense = random.nextInt(16);
        int special = random.nextInt(16);
        int speed = random.nextInt(16);
        int hp = ((attack & leastSignificantBitMask) << 3) + ((defense & leastSignificantBitMask) << 2) + ((speed & leastSignificantBitMask) << 1) + (special & leastSignificantBitMask);

        return new DeterminantValues(0L, hp, attack, defense, special, special, speed);
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
}
