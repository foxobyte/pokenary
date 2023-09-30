//package com.foxobyte.pokenary.constants;
//
//import com.fasterxml.jackson.annotation.JsonValue;
//
//import java.util.List;
//
//public enum Pokemon {
//    private Integer nationalNumber;
//    private List<Type> type;
//    private String name;
//    private Integer hp;
//    private Integer attack;
//    private Integer defense;
//    private Integer specialAttack;
//    private Integer specialDefense;
//    private Integer speed;
//
//    Pokemon(Integer nationalNumber, List<Type> type, String name, Integer hp, Integer attack, Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
//        this.nationalNumber = nationalNumber;
//        this.type = type;
//        this.name = name;
//        this.hp = hp;
//        this.attack = attack;
//        this.defense = defense;
//        this.specialAttack = specialAttack;
//        this.specialDefense = specialDefense;
//        this.speed = speed;
//    }
//
//    enum Type {
//        NORMAL("Normal"),
//        FIRE("Fire"),
//        WATER("Water"),
//        ELECTRIC("Electric"),
//        GRASS("Grass"),
//        ICE("Ice"),
//        FIGHTING("Fighting"),
//        POISON("Poison"),
//        GROUND("Ground"),
//        FLYING("Flying"),
//        PSYCHIC("Psychic"),
//        BUG("Bug"),
//        ROCK("Rock"),
//        GHOST("Ghost"),
//        DRAGON("Dragon"),
//        DARK("Dark"),
//        STEEL("Steel"),
//        FAIRY("Fairy");
//
//        private String name;
//
//        Type(String name) {
//            this.name = name;
//        }
//
//        @JsonValue
//        public String getType() {
//            return name;
//        }
//    }
//}
