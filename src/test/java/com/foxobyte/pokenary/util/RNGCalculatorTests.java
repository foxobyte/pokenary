package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.dao.pokemon.DeterminantValues;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static com.foxobyte.pokenary.util.RNGCalculator.generateDeterminantValues;
import static com.foxobyte.pokenary.util.RNGCalculator.generateIndividualValues;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RNGCalculatorTests {
    @Mock
    Random random = mock(Random.class);
    @InjectMocks
    RNGCalculator rngCalculator = new RNGCalculator(random);

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
    public void generateIndividualValuesTest() {
        Mockito.doReturn(0).when(random).nextInt(Mockito.anyInt());
        IndividualValues individualValues1 = generateIndividualValues();

        assertThat(individualValues1.getHp()).isEqualTo(0);
        assertThat(individualValues1.getAttack()).isEqualTo(0);
        assertThat(individualValues1.getDefense()).isEqualTo(0);
        assertThat(individualValues1.getSpecialAttack()).isEqualTo(0);
        assertThat(individualValues1.getSpecialDefense()).isEqualTo(0);
        assertThat(individualValues1.getSpeed()).isEqualTo(0);

        Mockito.doReturn(31).when(random).nextInt(Mockito.anyInt());
        IndividualValues individualValues2 = generateIndividualValues();

        assertThat(individualValues2.getHp()).isEqualTo(31);
        assertThat(individualValues2.getAttack()).isEqualTo(31);
        assertThat(individualValues2.getDefense()).isEqualTo(31);
        assertThat(individualValues2.getSpecialAttack()).isEqualTo(31);
        assertThat(individualValues2.getSpecialDefense()).isEqualTo(31);
        assertThat(individualValues2.getSpeed()).isEqualTo(31);
    }
}
