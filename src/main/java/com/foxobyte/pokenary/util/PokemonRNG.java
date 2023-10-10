package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;

import java.util.List;
import java.util.Random;

public class PokemonRNG {
    private static Random random = new Random();
    private static List<Nature> natures = List.of(Nature.values());

    public static Nature getRandomNature() {
        return natures.get(random.nextInt(natures.size()));
    }

    public static IndividualValues getRandomIndividualValues() {
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
