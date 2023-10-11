package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.pokemon.DeterminantValues;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Id;
import java.util.Random;
import java.util.Set;

import static com.foxobyte.pokenary.util.StatsCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PokemonStatsCalculatorTests {
    @Mock
    Random random = mock(Random.class);
    @Mock
    StatsCalculator statsCalculatorMock = mock(StatsCalculator.class);
    @InjectMocks
    StatsCalculator statsCalculator = new StatsCalculator(random);

    @Test
    public void generateDeterminantValuesTest() {
        Mockito.doReturn(1).when(random).nextInt(Mockito.anyInt());
        DeterminantValues determinantValues1 = generateDeterminantValues();

        assertThat(determinantValues1.getHp()).isEqualTo(15);
        assertThat(determinantValues1.getAttack()).isEqualTo(1);
        assertThat(determinantValues1.getDefense()).isEqualTo(1);
        assertThat(determinantValues1.getSpecialAttack()).isEqualTo(1);
        assertThat(determinantValues1.getSpecialDefense()).isEqualTo(1);
        assertThat(determinantValues1.getSpeed()).isEqualTo(1);

        Mockito.doReturn(0).when(random).nextInt(Mockito.anyInt());
        DeterminantValues determinantValues2 = generateDeterminantValues();

        assertThat(determinantValues2.getHp()).isEqualTo(0);
        assertThat(determinantValues2.getAttack()).isEqualTo(0);
        assertThat(determinantValues2.getDefense()).isEqualTo(0);
        assertThat(determinantValues2.getSpecialAttack()).isEqualTo(0);
        assertThat(determinantValues2.getSpecialDefense()).isEqualTo(0);
        assertThat(determinantValues2.getSpeed()).isEqualTo(0);

        Mockito.doReturn(15).when(random).nextInt(Mockito.anyInt());
        DeterminantValues determinantValues3 = generateDeterminantValues();

        assertThat(determinantValues3.getHp()).isEqualTo(15);
        assertThat(determinantValues3.getAttack()).isEqualTo(15);
        assertThat(determinantValues3.getDefense()).isEqualTo(15);
        assertThat(determinantValues3.getSpecialAttack()).isEqualTo(15);
        assertThat(determinantValues3.getSpecialDefense()).isEqualTo(15);
        assertThat(determinantValues3.getSpeed()).isEqualTo(15);
    }

    @Test
    public void calculatePokemonStatsWithDeterminantValuesTest() {
        Mockito.doReturn(15).when(random).nextInt(Mockito.anyInt());
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", Set.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
        WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, generateDeterminantValues());
        calculatePokemonStatsWithDeterminantValues(bulbasaur1);

        assertThat(bulbasaur1.getHp()).isEqualTo(230);
        assertThat(bulbasaur1.getAttack()).isEqualTo(133);
        assertThat(bulbasaur1.getDefense()).isEqualTo(133);
        assertThat(bulbasaur1.getSpecialAttack()).isEqualTo(165);
        assertThat(bulbasaur1.getSpecialDefense()).isEqualTo(165);
        assertThat(bulbasaur1.getSpeed()).isEqualTo(125);

        Mockito.doReturn(0).when(random).nextInt(Mockito.anyInt());
        WildPokemon bulbasaur2 = new WildPokemon(bulbasaur, 1, generateDeterminantValues());
        calculatePokemonStatsWithDeterminantValues(bulbasaur2);

        assertThat(bulbasaur2.getHp()).isEqualTo(11);
        assertThat(bulbasaur2.getAttack()).isEqualTo(5);
        assertThat(bulbasaur2.getDefense()).isEqualTo(5);
        assertThat(bulbasaur2.getSpecialAttack()).isEqualTo(6);
        assertThat(bulbasaur2.getSpecialDefense()).isEqualTo(6);
        assertThat(bulbasaur2.getSpeed()).isEqualTo(5);
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
    public void generateIndividualValuesTest() {
        Mockito.doReturn(0).when(random).nextInt(Mockito.anyInt());
        IndividualValues individualValues1 = generateIndividualValues();

        assertThat(individualValues1.getHp()).isEqualTo(0);
        assertThat(individualValues1.getAttack()).isEqualTo(0);
        assertThat(individualValues1.getDefense()).isEqualTo(0);
        assertThat(individualValues1.getSpecialAttack()).isEqualTo(0);
        assertThat(individualValues1.getSpecialDefense()).isEqualTo(0);
        assertThat(individualValues1.getSpeed()).isEqualTo(0);
    }

    @Test
    public void calculatePokemonStatsWithIndividualValuesTest() {
        Mockito.doReturn(31).when(random).nextInt(Mockito.anyInt());
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", Set.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
        WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, generateIndividualValues(), Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur1);

        assertThat(bulbasaur1.getHp()).isEqualTo(231);
        assertThat(bulbasaur1.getAttack()).isEqualTo(134);
        assertThat(bulbasaur1.getDefense()).isEqualTo(134);
        assertThat(bulbasaur1.getSpecialAttack()).isEqualTo(166);
        assertThat(bulbasaur1.getSpecialDefense()).isEqualTo(166);
        assertThat(bulbasaur1.getSpeed()).isEqualTo(126);

        Mockito.doReturn(0).when(random).nextInt(Mockito.anyInt());
        WildPokemon bulbasaur2 = new WildPokemon(bulbasaur, 1, generateIndividualValues(), Nature.HARDY);
        calculatePokemonStatsWithIndividualValues(bulbasaur2);

        assertThat(bulbasaur2.getHp()).isEqualTo(11);
        assertThat(bulbasaur2.getAttack()).isEqualTo(5);
        assertThat(bulbasaur2.getDefense()).isEqualTo(5);
        assertThat(bulbasaur2.getSpecialAttack()).isEqualTo(6);
        assertThat(bulbasaur2.getSpecialDefense()).isEqualTo(6);
        assertThat(bulbasaur2.getSpeed()).isEqualTo(5);
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
