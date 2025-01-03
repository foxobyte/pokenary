package com.foxobyte.pokenary.dao.pokemon;

import com.foxobyte.pokenary.constants.Nature;

public interface IPokemon {
    Pokemon getPokemon();
    void setPokemon();
    Integer getLevel();
    void setHp(Integer hp);
    Integer getHp();

    void setAttack(Integer attack);
    Integer getAttack();
    void setDefense(Integer defense);
    Integer getDefense();
    void setSpecialAttack(Integer specialAttack);
    Integer getSpecialAttack();
    void setSpecialDefense(Integer specialDefense);
    Integer getSpecialDefense();
    void setSpeed(Integer speed);
    Integer getSpeed();
    void setNature(Nature nature);
    Nature getNature();
    IndividualValues getIndividualValues();
    EffortValues getEffortValues();
}
