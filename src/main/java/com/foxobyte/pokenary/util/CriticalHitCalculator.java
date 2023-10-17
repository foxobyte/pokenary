package com.foxobyte.pokenary.util;

import java.util.Random;

public class CriticalHitCalculator {
    private static Random random = new Random();


    public static boolean checkIsCriticalHitGeneration1(int baseSpeed, boolean ishighCritMove, boolean focus) {
        int threshold = random.nextInt(256);
        int chance = 0;

        if (ishighCritMove && focus) {
            chance = (int) (4 * Math.floor((float) baseSpeed / 4));
        } else if (ishighCritMove) {
            chance = (int) Math.min(8 * Math.floor((float) baseSpeed / 2), 255);
        } else if (focus) {
            chance = (int) Math.floor((float) baseSpeed / 8);
        } else {
            chance = (int) Math.floor((float) baseSpeed / 2);
        }

        return chance < threshold;
    }

    public static boolean checkIsCriticalHitGeneration2(int stage) {
        int threshold = random.nextInt(256);

        if (stage == 0) {
            return 17 < threshold;
        } else if (stage == 1) {
            return 32 < threshold;
        } else if (stage == 2) {
            return 64 < threshold;
        } else if (stage == 3) {
            return 85 < threshold;
        } else {
            return 128 < threshold;
        }
    }
}
