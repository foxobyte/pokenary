package com.foxobyte.pokenary.util;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.foxobyte.pokenary.util.DamageCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DamageCalculatorTests {

    @Test
    public void calculateDamageGeneration1Test() {
        /*
         * Modeled off a level 50 Balbasaur using Solar Beam against a level 50 Chansey all 0 DV
         * */
        List<Float> allPossibleRandomValues = IntStream.range(217, 256).mapToObj(i -> (float) i / 255).toList();
        allPossibleRandomValues.forEach(r -> {
            Integer damage = calculateBaseDamageGeneration1(50, 1, 101, 141, 120);
            damage += (int) Math.floor((float) damage / 2);
            assertThat(damage).isBetween(49, 58);
        });
//        Integer damage1 = calculateDamageGeneration1(50, 1, 101, 141, 20, 1.5f, 1f, 1f, 1f);
//        assertThat(damage1).isEqualTo(12);
    }

    @Test
    public void calculateDamageGeneration2Test() {
        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        List<Float> allPossibleRandomValues = IntStream.range(217, 256).mapToObj(i -> (float) i / 255).toList();
        allPossibleRandomValues.forEach(r -> {
            Integer damage = calculateBaseDamageGeneration2(50, 101, 141, 120, 1f, 1);
            damage += (int) Math.floor((float) damage / 2);
            assertThat(damage).isBetween(49, 58);
        });
    }

    @Test
    public void calculateDamageGeneration3Test() {
        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        List<Float> allPossibleRandomValues = IntStream.range(85, 101).mapToObj(i -> (float) i / 255).toList();
        allPossibleRandomValues.forEach(r -> {
            Integer damage = calculateDamageGeneration3(50, 20, 101, 141, 1f, 1f, 1f, 1f, 1f, 1, 1, 1, 1, 1f, 1.5f, 1f, r);
            assertThat(damage).isBetween(10, 12);
        });
    }

    @Test
    public void calculateDamageGeneration4Test() {
        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        List<Float> allPossibleRandomValues = IntStream.range(85, 101).mapToObj(i -> (float) i / 255).toList();
        allPossibleRandomValues.stream().forEach(r -> {
            Integer damage = calculateDamageGeneration4(50, 20, 101, 141, 1f, 1f, 1f, 1f, 1f, 1, 1f, 1f, r, 1f, 1f, 1f, 1f, 1f, 1, 1f);
            assertThat(damage).isBetween(10, 12);
        });
    }

    @Test
    public void calculateDamageGeneration5OnwardTest() {
        /*
         * Modeled off a level 50 Balbasaur using Absorb against a level 50 Chansey all 0 DV
         * */
        List<Float> allPossibleRandomValues = IntStream.range(85, 101).mapToObj(i -> (float) i / 255).toList();
        allPossibleRandomValues.stream().forEach(r -> {
            Integer damage = calculateDamageGeneration5Onward(50, 101, 141, 20, 1f, 1f, 1f, 1, 1f, r, 1f, 1f, 1f, 1f, 1f, 1f);
            assertThat(damage).isBetween(10, 12);
        });
    }
}
