package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Map;

// ToDo: verify
public enum Type {
    NORMAL("Normal", List.of(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, .5f, 0f, 1f, 1f, .5f, 1f)),
    FIRE("Fire", List.of(1f, .5f, .5f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 1f, 1f, 1f)),
    WATER("Water", List.of(1f, 2f, .5f, 1f, .5f, 1f, 1f, 1f,2f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, 1f, 1f)),
    ELECTRIC("Electric", List.of(1f, 1f, 2f, .5f, .5f, 1f, 1f, 1f, 0f, 2f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f)),
    GRASS("Grass", List.of(1f, .5f, 2f, 1f, .5f, 1f, 1f, .5f, 2f, .5f, 1f, .5f, 2f, 1f, .5f, 1f, .5f, 1f)),
    ICE("Ice", List.of(1f, .5f, .5f, 1f, 2f, .5f, 1f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f)),
    FIGHTING("Fighting", List.of(2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, .5f, .5f, .5f, 2f, 0f, 1f, 2f, 2f, .5f)),
    POISON("Poison", List.of(1f, 1f, 1f, 1f, 2f, 1f, 1f, .5f, .5f, 1f, 1f, 1f, .5f, .5f, 1f, 1f, 0f, 2f)),
    GROUND("Ground", List.of(1f, 2f, 1f, 2f, .5f, 1f, 1f, 2f, 1f, 0f, 1f, .5f, 2f, 1f, 1f, 1f, 2f, 1f)),
    FLYING("Flying", List.of(1f, 1f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, 1f, 1f, .5f, 1f)),
    PSYCHIC("Psychic", List.of(1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, 1f, 1f, .5f, 1f, 1f, 1f, 1f, 0f, .5f, 1f)),
    BUG("Bug", List.of(1f, .5f, 1f, 1f, 2f, 1f, .5f, .5f, 1f, .5f, 2f, 1f, 1f, .5f, 1f, 2f, .5f, .5f)),
    ROCK("Rock", List.of(1f, 2f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, .5f, 1f)),
    GHOST("Ghost", List.of(0f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, 1f)),
    DRAGON("Dragon", List.of(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 0f)),
    DARK("Dark", List.of(1f, 1f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, .5f)),
    STEEL("Steel", List.of(1f, .5f, .5f, .5f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 1f, .5f, 2f)),
    FAIRY("Fairy", List.of(1f, .5f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, .5f, 1f));

    private String name;
    private List<Float> effectiveness;

    Type(String name, List<Float> effectiveness) {
        this.name = name;
        this.effectiveness = effectiveness;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public List<Float> getEffectiveness() {
        return this.effectiveness;
    }
}
