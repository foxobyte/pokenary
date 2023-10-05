package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;

public enum Nature implements INature {
    HARDY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            return pokemon;
        }
    },
    LONELY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 1.1));
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 0.9));

            return pokemon;
        }
    },
    BRAVE() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 1.1));
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 0.9));

            return pokemon;
        }
    },
    ADAMANT() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 1.1));
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 0.9));

            return pokemon;
        }
    },
    NAUGHTY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 1.1));
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 0.9));

            return pokemon;
        }
    },
    BOLD() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 1.1));
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 0.9));

            return pokemon;
        }
    },
    DOCILE() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            return pokemon;
        }
    },
    RELAXED() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 1.1));
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 0.9));

            return pokemon;
        }
    },
    IMPISH() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 1.1));
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 0.9));

            return pokemon;
        }
    },
    LAX() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 1.1));
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 0.9));

            return pokemon;
        }
    },
    TIMID() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 1.1));
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 0.9));

            return pokemon;
        }
    },
    HASTY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 1.1));
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 0.9));

            return pokemon;
        }
    },
    SERIOUS() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            return pokemon;
        }
    },
    JOLLY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 1.1));
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 0.9));

            return pokemon;
        }
    },
    NAIVE() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 1.1));
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 0.9));

            return pokemon;
        }
    },
    MODEST() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 1.1));
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 0.9));

            return pokemon;
        }
    },
    MILD() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 1.1));
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 0.9));

            return pokemon;
        }
    },
    QUIET() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 1.1));
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 0.9));

            return pokemon;
        }
    },
    BASHFUL() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            return pokemon;
        }
    },
    RASH() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 1.1));
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 0.9));

            return pokemon;
        }
    },
    CALM() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 1.1));
            pokemon.setAttack((int) Math.floor(pokemon.getAttack() * 0.9));

            return pokemon;
        }
    },
    GENTLE() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 1.1));
            pokemon.setDefense((int) Math.floor(pokemon.getDefense() * 0.9));

            return pokemon;
        }
    },
    SASSY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 1.1));
            pokemon.setSpeed((int) Math.floor(pokemon.getSpeed() * 0.9));

            return pokemon;
        }
    },
    CAREFUL() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            pokemon.setSpecialDefense((int) Math.floor(pokemon.getSpecialDefense() * 1.1));
            pokemon.setSpecialAttack((int) Math.floor(pokemon.getSpecialAttack() * 0.9));

            return pokemon;
        }
    },
    QUIRKY() {
        @Override
        public IPokemon calculateNature(IPokemon pokemon) {
            return pokemon;
        }
    };
}
