package com.foxobyte.pokenary.util;

import java.util.Random;

public class CatchRateCalculator {
    private Random random = new Random();

    public void checkIsCaughtGeneration1(int maxHp, int currentHp, float ball) {
        int check = random.nextInt();
        int f = (int) Math.floor(((float) maxHp * 255 * 4) / (currentHp * ball));

        System.out.println();
    }
}
