package com.foxobyte.pokenary.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EggGroup {
    MONSTER("Monster"),
    WATER_1("Water 1"),
    BUG("Bug"),
    FLYING("Flying"),
    FIELD("Field"),
    FAIRY("Fairy"),
    GRASS("Grass"),
    HUMAN_LIKE("Human Like"),
    WATER_3("Water 3"),
    MINERAL("Mineral"),
    AMORPHOUS("Amorphous"),
    WATER_2("Water 2"),
    DRAGON("Dragon");

    private String name;

    EggGroup(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
