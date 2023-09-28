package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Entity;

public enum Type {
    NORMAL("Normal"),
    FIRE("Fire"),
    WATER("Water"),
    ELECTRIC("Electric"),
    GRASS("Grass"),
    ICE("Ice"),
    FIGHTING("Fighting"),
    POISON("Poison"),
    GROUND("Ground"),
    FLYING("Flying"),
    PSYCHIC("Psychic"),
    BUG("Bug"),
    ROCK("Rock"),
    GHOST("Ghost"),
    DRAGON("Dragon"),
    DARK("Dark"),
    STEEL("Steel"),
    FAIRY("Fairy");

    private String name;

    Type(String name) {
        this.name = name;
    }

    @JsonValue
    public String getType() {
        return name;
    }
}
