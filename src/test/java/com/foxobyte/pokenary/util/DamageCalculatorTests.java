package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.foxobyte.pokenary.util.DamageCalculator.*;
import static com.foxobyte.pokenary.util.StatsCalculator.generateDeterminantValues;
import static com.foxobyte.pokenary.util.StatsCalculator.generateIndividualValues;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@SpringBootTest
public class DamageCalculatorTests {
    @Test
    public void calculateDamageGeneration1Test() {
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", Set.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
        WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, generateDeterminantValues());

        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        Integer damage1 = calculateDamageGeneration1(bulbasaur1.getLevel(), 1, 20, 101, 141, 1.5f, 1f, 1f, 1f);
        assertThat(damage1).isEqualTo(12);
    }

    @Test
    public void calculateDamageGeneration2Test() {
//        Integer damage1 = calculateDamageGeneration2();
    }

    @Test
    public void calculateDamageGeneration3Test() {

    }

    @Test
    public void calculateDamageGeneration4Test() {

    }

    @Test
    public void calculateDamageGeneration5OnwardTest() {

    }
}
