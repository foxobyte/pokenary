package com.foxobyte.pokenary.util;


/**
 * @link <a href="https://bulbapedia.bulbagarden.net/wiki/Damage">Bulbapedia</a>
 * */
public class DamageCalculator {
    /**
     * @param level         int value of the level of the attacking Pokémon
     * @param critical      is 2 for a critical hit, and 1 if otherwise
     * @param attack        int value of the effective attack stat of the attacking Pokémon for physical category moves or
     *                          int value of the effective special stat of the attacking Pokémon for special category moves
     * @param defense       int value of the effective defense stat of the defending Pokémon for physical category moves or
     *                          int value of the effective special stat of the defending Pokémon for special category moves
     * @param power         int value of the power of the move being used
     * @param stab          Same Type Attack Bonus
     *                          float value of 1.5 if the attacking Pokémon's move's type is the same as the attacking Pokémon's type.
     *                          float value of 1.0 otherwise.
     * @param type1         float value of the type effectiveness of the attacking Pokémon's move vs the defending Pokémon first type
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     * @param type2         float value of the type effectiveness of the attacking Pokémon's move vs the defending Pokémon second type
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     * @param random        float value for the variance in the damage calculation
     *                          a random uniformly distributed integer between 217 and 255 inclusive divided by 255
     *                          If the damage before random is 1 random is 1
     *
     * @return              int value of the damage calculated
     * */
    public static Integer calculateDamageGeneration1(Integer level, Integer critical, Integer attack, Integer defense, Integer power, Float stab, Float type1, Float type2, Float random) {
        Float A = (float) attack;
        Float D = (float) defense;
        // ToDo: Verify Equation
        Float damage = ((float) Math.floor(((((float) (2 * level * critical) / 5) + 2) * power * (A / D)) / 50) + 2) * stab * type1 * type2;

        if (damage.intValue() == 1) random = 1f;
        damage *= random;

        return damage.intValue();
    }

    /**
     * @param level         int value of the level of the attacking Pokémon
     * @param attack        int value of the effective attack stat of the attacking Pokémon for physical category moves or
     *                          int value of the effective special attack stat of the attacking Pokémon for special category moves
     * @param defense       int value of the effective defense stat of the defending Pokémon for physical category moves or
     *                          int value of the effective special defense stat of the defending Pokémon for special category moves
     * @param power         int value of the power of the move being used
     * @param item          float value of 1.1 if the attacking Pokémon is holding a type-enhancing held item. 1 otherwise
     * @param critical      int value of 2 if the attacking Pokémon lands a critical hit, but 1 otherwise. Always 1 if the move used is Flail, Reversal or Future Sight.
     * @param tk            int value of 1, 2 or 3 for each successive hit of the move Triple Kick. Always 1 otherwise
     * @param weather       float value of 1.5 if a water-type move is being used during rain.
     *                          float value of 1.5 if a fire-type move is being used during harsh sunlight.
     *                          float value of 0.5 if a water-type move is being used during harsh sunlight.
     *                          float value of 0.5 if Solar Beam or any fire-type move is being used during rain.
     *                          float value of 1 otherwise.
     * @param badge         float value of 1.125 if the attacking Pokémon's Player has obtained a badge of the same type as the attacking move's type
     * @param stab          Same Type Attack Bonus
     *                          float value of 1.5 if the attacking Pokémon's move's type is the same as the attacking Pokémon's type.
     *                          float value of 1.0 otherwise.
     * @param type          float value of the type effectiveness of the attacking Pokémon's move type vs the defending Pokémon's types
     *                          0.25    (not very effective)
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     *                          4.0     (super effective)
     * @param moveMod       int value for the values of
     *                          Rollout      $2^{n + d}$
     *                          Fury Cutter  $2^{n}$
     *                          Rage         $n$
     * @param random        float value for the variance in the damage calculation
     *                          a random uniformly distributed integer between 217 and 255 inclusive divided by 255
     *                          Always 1 if the moves Flail or Reversal are used
     * @param doubleDamage  int value of 2 if the used move is
     *                          Pursuit
     *                          Stomp
     *                          Gust or Twister
     *                          Earthquake or Magnitude
     *                          int value of 1 otherwise
     *
     * @return              int value of the damage calculated
     * */
    public static Integer calculateDamageGeneration2(Integer level, Integer attack, Integer defense, Integer power, Float item, Integer critical, Integer tk, Float weather, Float badge, Float stab, Float type, Integer moveMod, Float random, Integer doubleDamage) {
        Float A = (float) attack;
        Float D = (float) defense;
        // ToDo: Floor values
        Float damage = ((((((2 * level) / 5) + 2) * power * (A / D)) / 50) * item * critical + 2) * tk * weather * badge * stab * type * moveMod * random * doubleDamage;
        return damage.intValue();
    }

    /**
     * @param level         int value of the level of the attacking Pokémon
     * @param attack        int value of the effective attack stat of the attacking Pokémon for physical category moves or
     *                          int value of the effective special attack stat of the attacking Pokémon for special category moves
     * @param defense       int value of the effective defense stat of the defending Pokémon for physical category moves or
     *                          int value of the effective special defense stat of the defending Pokémon for special category moves
     * @param power         int value of the power of the move being used
     * @param burn          float value of 0.5 if the attacking Pokémon is burned, doesn't have the ability Guts and the move used is a physical move
     *                          float value of 1.0 otherwise
     * @param screen        float value of 0.5 if
     *                          the used move is a physical-type move and Reflect is active on the defending side or
     *                          the used move is a special-type move and Light Screen is active on the defending side.
     *                          In Double Battles a float value of .66 ToDo: finish this
     * @param targets       float value of 0.5 in Double Battles if the attacking move targets both defending Pokémon.
     *                          float value of 1.0 if the attacking move targets all Pokémon like Earthquake
     *                          float value of 1.0 otherwise
     * @param weather       float value of 1.5 if a water-type move is being used during rain.
     *                          float value of 1.5 if a fire-type move is being used during harsh sunlight.
     *                          float value of 0.5 if a water-type move is being used during harsh sunlight.
     *                          float value of 0.5 if Solar Beam or any fire-type move is being used during rain.
     *                          float value of 1.0 if any Pokémon have the ability Cloud Nine or Air Lock
     *                          float value of 1.0 otherwise.
     * @param ff            float value of 1.5 if any fire-type move is used with the ability Flash Fire
     *                          float value of 1.0 otherwise
     * @param stockpile     int value of 1, 2 or 3 if the used move is Spit Up, depending on how many time Stockpiles have been used resetting after 3
     *                          int value of 1 if the move used is not Spit Up
     * @param critical      int value of 2 for a critical hit.
     *                          int value of 1 if the used move is Future Sight, Doom Desire or Spit Up.
     *                          int value of 1 if the defending Pokémon has the ability Battle Armor or Shell Armor
     *                          int value of 1 otherwise
     * @param doubleDamage  int value of 2 if the move used is
     *                          Gust or Twister and the defending Pokémon is in the semi-invulnerable state of Fly or Bounce.
     *                          Stomp, Needle Arm, Astonish or Extrasensory and the defending Pokémon previously used Minimize.
     *                          Surf or Whirlpool and the defending Pokémon is in the semi-invulnerable state of Dig.
     *                          Pursuit and the defending Pokémon is attempting to switch out.
     *                          Facade and the attacking Pokémon is Poisoned, Burned or Paralyzed.
     *                          SmellingSalt and the defending Pokémon is Paralyzed.
     *                          Revenge and the attacking Pokémon has been damaged by the defending Pokémon this turn.
     *                          Weather Ball, there is non-clear weather and no Pokémon have the ability Cloud Nine or Air Lock.
     * @param charge        int value of 2 if the move used is electric-type and Charge was previously used.
     *                          int value of 1 otherwise
     * @param hh            float value of 1.5 if the attacking Pokémon's ally used the move Helping Hand.
     *                          float value of 1.0 otherwise
     * @param stab          Same Type Attack Bonus
     *                          float value of 1.5 if the attacking Pokémon's move's type is the same as the attacking Pokémon's type.
     *                          float value of 1.0 otherwise.
     * @param type          float value of the type effectiveness of the attacking Pokémon's move vs the defending Pokémon types
     *                          0.25    (not very effective)
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     *                          4.0     (super effective)
     * @param random        float value for the variance in the damage calculation
     *                          a random uniformly distributed integer between 85 and 100 inclusive divided by 100
     *                          always 1 if Spit Up is used
     *
     * @return              int value of the damage calculated
     * */
    public static Integer calculateDamageGeneration3(Integer level, Integer power, Integer attack, Integer defense, Float burn, Float screen, Float targets, Float weather, Float ff, Integer stockpile, Integer critical, Integer doubleDamage, Integer charge, Float hh, Float stab, Float type, Float random) {
        Float A = (float) attack;
        Float D = (float) defense;
        // ToDo: Floor values
        Float damage = ((((((2 * level) / 5) + 2) * power * (A / D)) / 50) * burn * screen * targets * weather * ff + 2) * stockpile * critical * doubleDamage * charge * hh * stab * type * random;
        return damage.intValue();
    }

    /**
     * @param level         int value of the level of the attacking Pokémon
     * @param attack        int value of the effective attack stat of the attacking Pokémon for physical category moves or
     *                          int value of the effective special attack stat of the attacking Pokémon for special category moves
     * @param defense       int value of the effective defense stat of the defending Pokémon for physical category moves or
     *                          int value of the effective special defense stat of the defending Pokémon for special category moves
     * @param power         int value of the power of the move being used
     * @param burn          float value of 0.5 if the attacking Pokémon is burned, doesn't have the ability Guts and the move used is a physical move
     *                          float value of 1.0 otherwise
     * @param screen        float value of 0.5 if
     *                          the used move is a physical-type move and Reflect is active on the defending side or
     *                          the used move is a special-type move and Light Screen is active on the defending side.
     *                          In Double Battles a float value of .66 ToDo: finish this
     * @param targets       float value of 0.75 in a Double Battle if the move used targets more than 1 Pokémon and there is more than 1 defending Pokémon when the move is used.
     *                          float value of 1.0 otherwise.
     * @param weather       float value of 1.5 if a water-type move is being used during rain.
     *                          float value of 1.5 if a fire-type move is being used during harsh sunlight.
     *                          float value of 0.5 if a water-type move is being used during harsh sunlight.
     *                          float value of 0.5 if Solar Beam or any fire-type move is being used during rain.
     *                          float value of 1.0 if any Pokémon have the ability Cloud Nine or Air Lock
     *                          float value of 1.0 otherwise.
     * @param ff            float value of 1.5 if any fire-type move is used with the ability Flash Fire
     *                          float value of 1.0 otherwise
     * @param critical      int value of 2 for a critical hit.
     *                          int value of 1 if the used move is Future Sight, Doom Desire or Spit Up.
     *                          int value of 1 if the defending Pokémon has the ability Battle Armor or Shell Armor
     *                          int value of 1 otherwise
     * @param item          float value of 1.3 is the attacking Pokémon is holding a Life Orb.
     *                          float value of $1 + \frac{n}{10}$ if the attacking Pokémon is holding the item Metronome, where n is the number of times the same move is used.
     *                          float value of 1.0 otherwise.
     * @param first         float value of 1.5 if the move Me First is used.
     *                          float value of 1.0 otherwise.
     * @param random        float value for the variance in the damage calculation
     *                          a random uniformly distributed integer between 85 and 100 inclusive divided by 100
     *                          always 1 if Spit Up is used
     * @param stab          Same Type Attack Bonus
     *                          float value of 1.5 if the attacking Pokémon's move's type is the same as the attacking Pokémon's type.
     *                          float value of 1.0 otherwise.
     * @param type1         float value of the type effectiveness of the attacking Pokémon's move vs the defending Pokémon first type
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     * @param type2         float value of the type effectiveness of the attacking Pokémon's move vs the defending Pokémon second type
     *                          0.5     (not very effective)
     *                          1.0     (normally effective)
     *                          2.0     (super effective)
     * @param srf           float value of 0.75 if the move used is super effective and the defending Pokémon has the ability Solid Rock or Filter and if the attacking Pokémon's Ability is not Mold Breaker.
     *                          float value of 1.0 otherwise.
     * @param eb            float value of 1.2 if the move used is super effective and the attacking Pokémon is holding the item Expert Belt.
     *                          float value of 1.0 otherwise.
     * @param tl            int value of 2 if the move used is not very effective and the attacking Pokémon's ability is Tinted Lens.
     *                          int value of 1 otherwise.
     * @param berry         float value of 0.5 if the move used is super effective and the defending Pokémon is holding a Berry that weakens it.
     *                          float value of 0.5 if a normal-type move is used and the defending Pokémon is holding a Chilan Berry.
     *                          float value of 1.0 otherwise.
     *
     * @return              int value of the damage calculated
     * */
    public static Integer calculateDamageGeneration4(Integer level, Integer power, Integer attack, Integer defense, Float burn, Float screen, Float targets, Float weather, Float ff, Integer critical, Float item, Float first, Float random, Float stab, Float type1, Float type2, Float srf, Float eb, Integer tl, Float berry) {
        Float A = (float) attack;
        Float D = (float) defense;
        // ToDo: Floor values
        Float damage = (((((2 * level) / 5) + 2) * power * (A / D) / 50) * burn * screen * targets * weather * ff + 2) * critical * item * first * random * stab * type1 * type2 * srf * eb * tl * berry;
        return damage.intValue();
    }

    /**
     * @param level         int value of the level of the attacking Pokémon
     * @param attack        int value of the effective attack stat of the attacking Pokémon for physical category moves or
     *                          int value of the effective special attack stat of the attacking Pokémon for special category moves
     * @param defense       int value of the effective defense stat of the defending Pokémon for physical category moves or
     *                          int value of the effective special defense stat of the defending Pokémon for special category moves
     * @param power         int value of the power of the move being used
     * @param targets       float value of 0.75 if the move targets more than 1 defending Pokémon.
     *                          float value of 0.5 in Battle Royals and the move targets more than 1 defending Pokémon.
     *                          float value of 1.0 otherwise.
     * @param pb            float value of 0.25 if the move is the second strike of the move Parental Bond.
     *                          float value of 0.5 in generation 6.
     *                          float value of 1.0 otherwise.
     * @param weather       float value of 1.5 if a water-type move is being used during rain.
     *                          float value of 1.5 if a fire-type move is being used during harsh sunlight.
     *                          float value of 0.5 if a water-type move is being used during harsh sunlight.
     *                          float value of 0.5 if Solar Beam or any fire-type move is being used during rain.
     *                          float value of 1.0 if any Pokémon have the ability Cloud Nine or Air Lock
     *                          float value of 1.0 otherwise.
     * @param glaiveRush    int value of 2 if previous move used by the attacking Pokémon was Glaive Rush.
     *                          int value of 1 otherwise.
     * @param critical
     * @param random        float value for the variance in the damage calculation
     *                          a random uniformly distributed integer between 85 and 100 inclusive divided by 100
     * @param stab          Same Type Attack Bonus
     *                          float value of 1.5 if the attacking Pokémon's move's type is the same as the attacking Pokémon's type.
     *                          float value of 1.0 otherwise.
     * @param type
     * @param burn          float value of 0.5 if the attacking Pokémon is burned, doesn't have the ability Guts and the move used is a physical move (Other than Facade from Generation 6+)
     *                          float value of 1.0 otherwise
     * @param other         ToDo: finish me
     * @param zMove         float value of 0.25 if the used move ToDo: finish me
     *                          float value of 1.0 otherwise.
     * @param teraShield    float value of 0.2 ToDo: finish me
     *                          float value of 1.0 otherwise.
     *
     * @return              int value of the damage calculated
     * */
    public static Integer calculateDamageGeneration5Onward(Integer level, Integer attack, Integer defense, Integer power, Float targets, Float pb, Float weather, Integer glaiveRush, Float critical, Float random, Float stab, Float type, Float burn, Float other, Float zMove, Float teraShield) {
        Float A = (float) attack;
        Float D = (float) defense;
        // ToDo: Floor values
        Float damage = ((((((2 * level) / 5) + 2) * power * (A / D)) / 50) + 2) * targets * pb * weather * glaiveRush * critical * random * stab * type * burn * other * zMove * teraShield;
        return damage.intValue();
    }
}
