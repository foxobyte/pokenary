package com.foxobyte.pokenary.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.foxobyte.pokenary.util.DamageCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@SpringBootTest
public class PokemonCalculatorTests {
    @Test
    public void calculateDamageGeneration1Test() {
        /*
        * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        Integer damage1 = calculateDamageGeneration1(50, 1, 20, 101, 141, 1.5f, 1f, 1f);
        assertThat(damage1).isCloseTo(11, within(1));
        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey
         * */
//        Integer damage2 = calculateDamageGeneration1(50f, 1f, 20f, 101f, 141f, 1.5f, 1f, 1f);
//        assertThat(damage2).isCloseTo(11, within(1));
    }

    @Test
    public void calculateDamageGeneration2Test() {

    }

    @Test
    public void calculatePokemonStatsGeneration1And2Test() {

    }
}
