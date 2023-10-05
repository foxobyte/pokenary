package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    NORMAL("Normal", 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, .5f, 0f, 1f, 1f, .5f, 1f),
    FIRE("Fire", 1f, .5f, .5f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 1f, 1f, 1f),
    WATER("Water", 1f, 2f, .5f, 1f, .5f, 1f, 1f, 1f,2f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, 1f, 1f),
    ELECTRIC("Electric", 1f, 1f, 2f, .5f, .5f, 1f, 1f, 1f, 0f, 2f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f),
    GRASS("Grass", 1f, .5f, 2f, 1f, .5f, 1f, 1f, .5f, 2f, .5f, 1f, .5f, 2f, 1f, .5f, 1f, .5f, 1f),
    ICE("Ice", 1f, .5f, .5f, 1f, 2f, .5f, 1f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f),
    FIGHTING("Fighting", 2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, .5f, .5f, .5f, 2f, 0f, 1f, 2f, 2f, .5f),
    POISON("Poison", 1f, 1f, 1f, 1f, 2f, 1f, 1f, .5f, .5f, 1f, 1f, 1f, .5f, .5f, 1f, 1f, 0f, 2f),
    GROUND("Ground", 1f, 2f, 1f, 2f, .5f, 1f, 1f, 2f, 1f, 0f, 1f, .5f, 2f, 1f, 1f, 1f, 2f, 1f),
    FLYING("Flying", 1f, 1f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, 1f, 1f, .5f, 1f),
    PSYCHIC("Psychic", 1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, 1f, 1f, .5f, 1f, 1f, 1f, 1f, 0f, .5f, 1f),
    BUG("Bug", 1f, .5f, 1f, 1f, 2f, 1f, .5f, .5f, 1f, .5f, 2f, 1f, 1f, .5f, 1f, 2f, .5f, .5f),
    ROCK("Rock", 1f, 2f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, .5f, 1f),
    GHOST("Ghost", 0f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, 1f),
    DRAGON("Dragon", 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 0f),
    DARK("Dark", 1f, 1f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, .5f),
    STEEL("Steel", 1f, .5f, .5f, .5f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 1f, .5f, 2f),
    FAIRY("Fairy", 1f, .5f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, .5f, 1f);

    private String name;
    private Float effectivenessAgainstNormal;
    private Float effectivenessAgainstFire;
    private Float effectivenessAgainstWater;
    private Float effectivenessAgainstElectric;
    private Float effectivenessAgainstGrass;
    private Float effectivenessAgainstIce;
    private Float effectivenessAgainstFighting;
    private Float effectivenessAgainstPoison;
    private Float effectivenessAgainstGround;
    private Float effectivenessAgainstFlying;
    private Float effectivenessAgainstPsychic;
    private Float effectivenessAgainstBug;
    private Float effectivenessAgainstRock;
    private Float effectivenessAgainstGhost;
    private Float effectivenessAgainstDragon;
    private Float effectivenessAgainstDark;
    private Float effectivenessAgainstSteel;
    private Float effectivenessAgainstFairy;

    Type(String name, Float effectivenessAgainstNormal, Float effectivenessAgainstFire, Float effectivenessAgainstWater, Float effectivenessAgainstElectric, Float effectivenessAgainstGrass, Float effectivenessAgainstIce, Float effectivenessAgainstFighting, Float effectivenessAgainstPoison, Float effectivenessAgainstGround, Float effectivenessAgainstFlying, Float effectivenessAgainstPsychic, Float effectivenessAgainstBug, Float effectivenessAgainstRock, Float effectivenessAgainstGhost, Float effectivenessAgainstDragon, Float effectivenessAgainstDark, Float effectivenessAgainstSteel, Float effectivenessAgainstFairy) {
        this.name = name;
        this.effectivenessAgainstNormal = effectivenessAgainstNormal;
        this.effectivenessAgainstFire = effectivenessAgainstFire;
        this.effectivenessAgainstWater = effectivenessAgainstWater;
        this.effectivenessAgainstElectric = effectivenessAgainstElectric;
        this.effectivenessAgainstGrass = effectivenessAgainstGrass;
        this.effectivenessAgainstIce = effectivenessAgainstIce;
        this.effectivenessAgainstFighting = effectivenessAgainstFighting;
        this.effectivenessAgainstPoison = effectivenessAgainstPoison;
        this.effectivenessAgainstGround = effectivenessAgainstGround;
        this.effectivenessAgainstFlying = effectivenessAgainstFlying;
        this.effectivenessAgainstPsychic = effectivenessAgainstPsychic;
        this.effectivenessAgainstBug = effectivenessAgainstBug;
        this.effectivenessAgainstRock = effectivenessAgainstRock;
        this.effectivenessAgainstGhost = effectivenessAgainstGhost;
        this.effectivenessAgainstDragon = effectivenessAgainstDragon;
        this.effectivenessAgainstDark = effectivenessAgainstDark;
        this.effectivenessAgainstSteel = effectivenessAgainstSteel;
        this.effectivenessAgainstFairy = effectivenessAgainstFairy;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public Float getEffectivenessAgainstNormal() {
        return effectivenessAgainstNormal;
    }

    public Float getEffectivenessAgainstFire() {
        return effectivenessAgainstFire;
    }

    public Float getEffectivenessAgainstWater() {
        return effectivenessAgainstWater;
    }

    public Float getEffectivenessAgainstElectric() {
        return effectivenessAgainstElectric;
    }

    public Float getEffectivenessAgainstGrass() {
        return effectivenessAgainstGrass;
    }

    public Float getEffectivenessAgainstIce() {
        return effectivenessAgainstIce;
    }

    public Float getEffectivenessAgainstFighting() {
        return effectivenessAgainstFighting;
    }

    public Float getEffectivenessAgainstPoison() {
        return effectivenessAgainstPoison;
    }

    public Float getEffectivenessAgainstGround() {
        return effectivenessAgainstGround;
    }

    public Float getEffectivenessAgainstFlying() {
        return effectivenessAgainstFlying;
    }

    public Float getEffectivenessAgainstPsychic() {
        return effectivenessAgainstPsychic;
    }

    public Float getEffectivenessAgainstBug() {
        return effectivenessAgainstBug;
    }

    public Float getEffectivenessAgainstRock() {
        return effectivenessAgainstRock;
    }

    public Float getEffectivenessAgainstGhost() {
        return effectivenessAgainstGhost;
    }

    public Float getEffectivenessAgainstDragon() {
        return effectivenessAgainstDragon;
    }

    public Float getEffectivenessAgainstDark() {
        return effectivenessAgainstDark;
    }

    public Float getEffectivenessAgainstSteel() {
        return effectivenessAgainstSteel;
    }

    public Float getEffectivenessAgainstFairy() {
        return effectivenessAgainstFairy;
    }
}
