package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.constants.GrowthRate;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static com.foxobyte.pokenary.util.ExperienceCalculator.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExperienceCalculatorTests {
    @Test
    public void calculateExperienceGainGeneration1To4Test() {

    }

    @Test
    public void calculateExperienceGainGeneration5Test() {

    }

    @Test
    public void calculateExperienceGainGeneration6Test() {

    }

    @Test
    public void calculateExperienceGainGeneration7OnwardTest() {

    }

    @Test
    public void calculateFastGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateFastGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.FAST.getExpectedValues().get(i - 1));
        });
    }

    @Test
    public void calculateMediumFastGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateMediumFastGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.MEDIUM_FAST.getExpectedValues().get(i - 1));
        });
    }

    @Test
    public void calculateMediumSlowGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateMediumSlowGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.MEDIUM_SLOW.getExpectedValues().get(i - 1));
        });
    }

    @Test
    public void calculateSlowGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateSlowGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.SLOW.getExpectedValues().get(i - 1));
        });
    }

    @Test
    public void calculateFluctuatingGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateFluctuatingGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.FLUCTUATING.getExpectedValues().get(i - 1));
        });
    }

    @Test
    public void calculateErraticGrowthRateTest() {
        IntStream.range(1, 101).forEach(i -> {
            int exp = calculateErraticGrowthRate(i);
            assertThat(exp).isEqualTo(GrowthRate.ERRATIC.getExpectedValues().get(i - 1));
        });
    }
}
