package com.foxobyte.pokenary.util;

/**
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Experience">Bulbapedia</a>
 * */
public class ExperienceCalculator {
    /**
     * Description
     *
     * $\Delta EXP = \frac{b \times L}{7} \times \frac{1}{s} \times e \times a \times t$
     *
     * @param b             int value of the base experience of the defeated Pokémon
     * @param l             int value of the level of the defeated Pokémon
     * @param s             if EXP. All is not in the player's bag
     *                          int value of the number of Pokémon participated in the battle and have not fainted otherwise
     *                          ToDo: this
     * @param e             float value of 1.5 if the winning Pokémon is holding a Lucky Egg.
     *                          float value of 1.0 otherwise.
     * @param a             float value of 1.0 if the defeated Pokémon is wild.
     *                          float value of 1.5 if the defeated Pokémon is owned.
     * @param t             float value of 1.0 if the current player is the original owner of the Pokémon.
     *                          float value of 1.5 otherwise. (i.e. the Pokémon has been traded)
     * */
    public static int calculateExperienceGainGeneration1To4(int b, int l, int s, float e, float a, float t) {
        return (int) (((b * l) / 7) * (1 / s) * e * a * t);
    }

    /**
     * Description
     *
     * $\Delta EXP = \left( \frac{b \times L}{5} \times a \times \frac{1}{s} \times \left( \frac{\lfloor \sqrt{2L + 10} \times \left(2L + 10\right)^2 \rfloor}{\lfloor \sqrt{L \times L_{p} + 10} \times \left(L + L_{p} + 10\right)^2 \rfloor} \right) + 1 \right) \times t \times e \times p$
     *
     * @param b             int value of the base experience of the defeated Pokémon
     * @param l             int value of the level of the defeated Pokémon
     * @param lp            int value of the level of the victorious Pokémon
     * @param a             float value of 1.0 if the defeated Pokémon is wild.
     *                          float value of 1.5 if the defeated Pokémon is owned.
     * @param s
     * @param t             float value of 1.0 if the current player is the original owner of the Pokémon.
     *                          float value of 1.5 otherwise. (i.e. the Pokémon has been traded)
     *                          float value of 6963/4096 if the Pokémon has a different language of origin.
     * @param e             float value of 1.5 if the winning Pokémon is holding a Lucky Egg.
     *                          float value of 1.0 otherwise.
     * @param p
     * */
    public static int calculateExperienceGainGeneration5(int b, int l, int lp, float a, int s, float t, float e, float p) {
        return (int) ((((b * l) / 5) * a * (1 / s) * (Math.floor(Math.sqrt(2*l+10) * Math.pow(2*l+10, 2) / Math.floor(Math.sqrt(l+lp+10) * Math.pow(l+lp+10, 2)))) + 1) * t * e * p);
    }

    /**
     * Description
     *
     * $\Delta EXP = \frac{b \times L}{7} \times a \times \frac{1}{s} \times t \times e \times v \times f \times p$
     *
     * @param b             int value of the base experience of the defeated Pokémon
     * @param l             int value of the level of the defeated Pokémon
     * @param s
     * @param a             float value of 1.0 if the defeated Pokémon is wild.
     *                          float value of 1.5 if the defeated Pokémon is owned.
     * @param t             float value of 1.0 if the current player is the original owner of the Pokémon.
     *                          float value of 1.5 otherwise. (i.e. the Pokémon has been traded)
     *                          float value of 1.7 if the Pokémon has a different language of origin.
     * @param e             float value of 1.5 if the winning Pokémon is holding a Lucky Egg.
     *                          float value of 1.0 otherwise.
     * @param v             float value of 4915/4096 (~1.2) if the victorious Pokémon is above its evolving level.
     *                          float value of 1.0 otherwise.
     * @param f
     * @param p
     * */
    public static int calculateExperienceGainGeneration6(int b, int l, int s, float a, float t, float e, float v, float f, float p) {
        return (int) (((b * l) / 7) * a * (1 / s) * t * e * v * f * p);
    }

    /**
     * Description
     *
     * $\Delta EXP = \left(\frac{b \times L}{5} \times \frac{1}{s} \times \left(\frac{2L+10}{L+L_{p}+10}\right)^{2.5} + 1 \right) \times t \times e \times v \times f \times p$
     *
     * @param b             int value of the base experience of the defeated Pokémon
     * @param l             int value of the level of the defeated Pokémon
     * @param lp            int value of the level of the victorious Pokémon
     * @param s
     * @param t             float value of 1.0 if the current player is the original owner of the Pokémon.
     *                          float value of 1.5 otherwise. (i.e. the Pokémon has been traded)
     *                          float value of 1.7 if the Pokémon has a different language of origin.
     * @param e             float value of 1.5 if the winning Pokémon is holding a Lucky Egg.
     *                          float value of 1.0 otherwise.
     * @param v             float value of 4915/4096 (~1.2) if the victorious Pokémon is above its evolving level.
     *                          float value of 1.0 otherwise.
     * @param f
     * @param p
     * */
    public static int calculateExperienceGainGeneration7Onward(int b, int l, int lp, int s, float t, float e, float v, float f, float p) {
        return (int) ((((b * l) / 5) * (1 / s) * Math.pow((double) (2*l+10) / (l+lp+10), 2.5d) + 1) * t * e * v * f * p);
    }

    /**
     * Calculate the experience required to reach level n
     *
     * $EXP = \frac{4n^3}{5}$
     *
     * @param n             int value of the level
     *
     * @return              return the total exp value required to reach level of n
     * */
    public static int calculateFastGrowthRate(int n) {
        return (int) ((4 * Math.pow(n, 3)) / 5);
    }

    /**
     * Calculate the experience required to reach level n
     *
     * $EXP = n^3$
     *
     * @param n             int value of the level
     * */
    public static int calculateMediumFastGrowthRate(int n) {
        if (n == 1) return 0;
        return (int) Math.pow(n, 3);
    }

    /**
     * Calculate the experience required to reach level n
     *
     * $EXP = \frac{6}{5}n^3 - 15n^2 + 100n - 140$
     *
     * @param n             int value of the level
     * */
    public static int calculateMediumSlowGrowthRate(int n) {
        if (n == 1) return 0;
        return (int) (((6f / 5) * Math.pow(n, 3)) - (15 * Math.pow(n, 2)) + (100 * n) - 140);
    }

    /**
     * Calculate the experience required to reach level n
     *
     * $\frac{5n^3}{4}$
     *
     * @param n             int value of the level
     * */
    public static int calculateSlowGrowthRate(int n) {
        if (n == 1) return 0;
        return (int) ((5 * Math.pow(n, 3)) / 4);
    }

    /**
     * Calculate the experience required to reach level of n
     *
     * $EXP = \begin{cases} \frac{n^3 \left( \lfloor\frac{n + 1}{3}\rfloor + 24\right)}{50} & n < 15 \\ \frac{n^3\left(n + 14\right)}{50} & 15 \le n < 36 \\ \frac{n^3\left(\lfloor\frac{n}{2}\rfloor + 32 \right)}{50} & 36 \le n < 100 \end{cases}$
     *
     * @param n             int value of the level
     * */
    public static int calculateFluctuatingGrowthRate(int n) {
        if (n < 15) {
            return (int) ((Math.pow(n, 3) * (Math.floor((float) (n + 1) / 3) + 24)) / 50);
        } else if (n < 36) {
            return (int) ((Math.pow(n, 3) * (float) (n + 14)) / 50);
        }
        return (int) ((Math.pow(n, 3) * (Math.floor(((float) n / 2)) + 32)) / 50);
    }

    /**
     * Calculate the experience required to reach level n
     *
     * $EXP = \begin{cases} \frac{n^3\left(100 - n\right)}{50} & n < 50 \\ \frac{n^3\left(150 - n\right)}{100} & 50 \le n < 68 \\ \frac{n^3\lfloor\frac{1911-10n}{3}\rfloor}{500} & 68 \le n < 98 \\ \frac{n^3\left(160 - n\right)}{100} & 98 \le n < 100 \end{cases}$
     *
     * @param n             int value of the level
     * */
    public static int calculateErraticGrowthRate(int n) {
        if (n == 1) return 0;
        if (n < 50) {
            return (int) ((Math.pow(n, 3) * (100 - n)) / 50);
        } else if (n < 68) {
            return (int) ((Math.pow(n, 3) * (150 - n)) / 100);
        } else if (n < 98) {
            return (int) ((Math.pow(n, 3) * Math.floor((float) (1911 - (10 * n)) / 3)) / 500);
        }
        return (int) ((Math.pow(n, 3) * (160 - n)) / 100);
    }
}
