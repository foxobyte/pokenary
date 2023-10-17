package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.pokemon.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.foxobyte.pokenary.util.StatsCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StatsCalculatorTests {
    @Mock
    StatsCalculator statsCalculatorMock = mock(StatsCalculator.class);
    @InjectMocks
    StatsCalculator statsCalculator;

    @Test
    public void calculatePokemonStatsWithDeterminantValuesTest() {
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", List.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
        StatExperience minStatExperience = new StatExperience(1L, 0, 0, 0, 0, 0, 0);
        StatExperience maxStatExperience = new StatExperience(1L, 65535, 65535, 65535, 65535, 65535, 65535);
        DeterminantValues minDeterminantValues = new DeterminantValues(1L, 0, 0, 0, 0, 0, 0);
        DeterminantValues maxDeterminantValues = new DeterminantValues(1L, 15, 15, 15, 15, 15, 15);

        WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, minDeterminantValues, minStatExperience);
        calculatePokemonStatsWithDeterminantValues(bulbasaur1);
        assertThat(bulbasaur1.getHp()).isEqualTo(200);
        assertThat(bulbasaur1.getAttack()).isEqualTo(103);
        assertThat(bulbasaur1.getDefense()).isEqualTo(103);
        assertThat(bulbasaur1.getSpecialAttack()).isEqualTo(135);
        assertThat(bulbasaur1.getSpecialDefense()).isEqualTo(135);
        assertThat(bulbasaur1.getSpeed()).isEqualTo(95);

        WildPokemon bulbasaur2 = new WildPokemon(bulbasaur, 100, maxDeterminantValues, minStatExperience);
        calculatePokemonStatsWithDeterminantValues(bulbasaur2);
        assertThat(bulbasaur2.getHp()).isEqualTo(230);
        assertThat(bulbasaur2.getAttack()).isEqualTo(133);
        assertThat(bulbasaur2.getDefense()).isEqualTo(133);
        assertThat(bulbasaur2.getSpecialAttack()).isEqualTo(165);
        assertThat(bulbasaur2.getSpecialDefense()).isEqualTo(165);
        assertThat(bulbasaur2.getSpeed()).isEqualTo(125);

        WildPokemon bulbasaur3 = new WildPokemon(bulbasaur, 100, minDeterminantValues, maxStatExperience);
        calculatePokemonStatsWithDeterminantValues(bulbasaur3);
        assertThat(bulbasaur3.getHp()).isEqualTo(264);
        assertThat(bulbasaur3.getAttack()).isEqualTo(167);
        assertThat(bulbasaur3.getDefense()).isEqualTo(167);
        assertThat(bulbasaur3.getSpecialAttack()).isEqualTo(199);
        assertThat(bulbasaur3.getSpecialDefense()).isEqualTo(199);
        assertThat(bulbasaur3.getSpeed()).isEqualTo(159);

        WildPokemon bulbasaur4 = new WildPokemon(bulbasaur, 100, maxDeterminantValues, maxStatExperience);
        calculatePokemonStatsWithDeterminantValues(bulbasaur4);
        assertThat(bulbasaur4.getHp()).isEqualTo(294);
        assertThat(bulbasaur4.getAttack()).isEqualTo(197);
        assertThat(bulbasaur4.getDefense()).isEqualTo(197);
        assertThat(bulbasaur4.getSpecialAttack()).isEqualTo(229);
        assertThat(bulbasaur4.getSpecialDefense()).isEqualTo(229);
        assertThat(bulbasaur4.getSpeed()).isEqualTo(189);
    }

    @Test
    public void convertIndividualValuesToDeterminantValuesTest() {
        IndividualValues individualValues1 = new IndividualValues(0L, 0, 0, 0, 0, 0, 0);
        DeterminantValues determinantValues1 = convertIndividualValuesToDeterminantValues(individualValues1);

        assertThat(determinantValues1.getHp()).isEqualTo(0);
        assertThat(determinantValues1.getAttack()).isEqualTo(0);
        assertThat(determinantValues1.getDefense()).isEqualTo(0);
        assertThat(determinantValues1.getSpecialAttack()).isEqualTo(0);
        assertThat(determinantValues1.getSpecialDefense()).isEqualTo(0);
        assertThat(determinantValues1.getSpeed()).isEqualTo(0);

        IndividualValues individualValues2 = new IndividualValues(0L, 31, 31, 31, 31, 31, 31);
        DeterminantValues determinantValues2 = convertIndividualValuesToDeterminantValues(individualValues2);

        assertThat(determinantValues2.getHp()).isEqualTo(15);
        assertThat(determinantValues2.getAttack()).isEqualTo(15);
        assertThat(determinantValues2.getDefense()).isEqualTo(15);
        assertThat(determinantValues2.getSpecialAttack()).isEqualTo(15);
        assertThat(determinantValues2.getSpecialDefense()).isEqualTo(15);
        assertThat(determinantValues2.getSpeed()).isEqualTo(15);
    }

    @Test
    public void calculatePokemonStatsWithIndividualValuesTest() {
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", List.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
        EffortValues minEffortValues = new EffortValues(1L, 0, 0, 0, 0, 0, 0);
        EffortValues maxEffortValues = new EffortValues(1L, 255, 255, 255, 255, 255, 255);
        IndividualValues minIndividualValues = new IndividualValues(1L, 0, 0, 0, 0, 0, 0);
        IndividualValues maxIndividualValues = new IndividualValues(1L, 31, 31, 31, 31, 31, 31);

        WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, minIndividualValues, minEffortValues, Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur1);

        assertThat(bulbasaur1.getHp()).isEqualTo(200);
        assertThat(bulbasaur1.getAttack()).isEqualTo(103);
        assertThat(bulbasaur1.getDefense()).isEqualTo(103);
        assertThat(bulbasaur1.getSpecialAttack()).isEqualTo(135);
        assertThat(bulbasaur1.getSpecialDefense()).isEqualTo(135);
        assertThat(bulbasaur1.getSpeed()).isEqualTo(95);

        WildPokemon bulbasaur2 = new WildPokemon(bulbasaur, 100, maxIndividualValues, minEffortValues, Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur2);

        assertThat(bulbasaur2.getHp()).isEqualTo(231);
        assertThat(bulbasaur2.getAttack()).isEqualTo(134);
        assertThat(bulbasaur2.getDefense()).isEqualTo(134);
        assertThat(bulbasaur2.getSpecialAttack()).isEqualTo(166);
        assertThat(bulbasaur2.getSpecialDefense()).isEqualTo(166);
        assertThat(bulbasaur2.getSpeed()).isEqualTo(126);

        WildPokemon bulbasaur3 = new WildPokemon(bulbasaur, 100, minIndividualValues, maxEffortValues, Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur3);

        assertThat(bulbasaur3.getHp()).isEqualTo(263);
        assertThat(bulbasaur3.getAttack()).isEqualTo(166);
        assertThat(bulbasaur3.getDefense()).isEqualTo(166);
        assertThat(bulbasaur3.getSpecialAttack()).isEqualTo(198);
        assertThat(bulbasaur3.getSpecialDefense()).isEqualTo(198);
        assertThat(bulbasaur3.getSpeed()).isEqualTo(158);

        WildPokemon bulbasaur4 = new WildPokemon(bulbasaur, 100, maxIndividualValues, maxEffortValues, Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur4);

        assertThat(bulbasaur4.getHp()).isEqualTo(294);
        assertThat(bulbasaur4.getAttack()).isEqualTo(197);
        assertThat(bulbasaur4.getDefense()).isEqualTo(197);
        assertThat(bulbasaur4.getSpecialAttack()).isEqualTo(229);
        assertThat(bulbasaur4.getSpecialDefense()).isEqualTo(229);
        assertThat(bulbasaur4.getSpeed()).isEqualTo(189);
    }

    @Test
    public void convertDeterminantValuesToIndividualValuesTest() {
        DeterminantValues determinantValues1 = new DeterminantValues(0L, 0, 0, 0, 0, 0, 0);
        IndividualValues individualValues1 = convertDeterminantValuesToIndividualValues(determinantValues1);

        assertThat(individualValues1.getHp()).isEqualTo(1);
        assertThat(individualValues1.getAttack()).isEqualTo(1);
        assertThat(individualValues1.getDefense()).isEqualTo(1);
        assertThat(individualValues1.getSpecialAttack()).isEqualTo(1);
        assertThat(individualValues1.getSpecialDefense()).isEqualTo(1);
        assertThat(individualValues1.getSpeed()).isEqualTo(1);

        DeterminantValues determinantValues2 = new DeterminantValues(0L, 15, 15, 15, 15, 15, 15);
        IndividualValues individualValues2 = convertDeterminantValuesToIndividualValues(determinantValues2);

        assertThat(individualValues2.getHp()).isEqualTo(31);
        assertThat(individualValues2.getAttack()).isEqualTo(31);
        assertThat(individualValues2.getDefense()).isEqualTo(31);
        assertThat(individualValues2.getSpecialAttack()).isEqualTo(31);
        assertThat(individualValues2.getSpecialDefense()).isEqualTo(31);
        assertThat(individualValues2.getSpeed()).isEqualTo(31);
    }
}
