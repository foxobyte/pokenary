package com.foxobyte.pokenary.dao.pokemon;

import lombok.Data;

import javax.persistence.*;

/**
 * Effort values are a thing that does stuff
 */
@Entity
@Table(name = "effort_values")
@Data
public class EffortValues {
    @Id
    @GeneratedValue
    private long effortValueId;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public EffortValues(Long effortValueId, Integer hp, Integer attack, Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
        this.effortValueId = effortValueId;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public Long getEffortValueId() {
        return effortValueId;
    }

    public void setEffortValueId(Long effortValueId) {
        this.effortValueId = effortValueId;
    }

    public Integer getHp() {
        return hp;
    }

    public void addHp(int hp) {
        if (getTotal() + hp > 510) {
            hp = getTotal() + hp - 510;
            this.hp += hp;
            return;
        }

        if (this.hp + hp > 252) {
            this.hp = 252;
            return;
        }

        this.hp += hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void addAttack(int attack) {
        if (getTotal() + attack > 510) {
            attack = getTotal() + attack - 510;
            this.attack += attack;
            return;
        }

        if (this.attack + attack > 252) {
            this.attack = 252;
            return;
        }

        this.attack += attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void addDefense(int defense) {
        if (getTotal() + defense > 510) return;

        if (this.defense + defense > 252) {
            this.defense = 252;
            return;
        }

        this.defense += defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void addSpecialAttack(int specialAttack) {
        if (getTotal() + specialAttack > 510) {
            specialAttack = getTotal() + specialAttack - 510;
            this.specialAttack += specialAttack;
            return;
        }

        if (this.specialAttack + specialAttack > 252) {
            this.specialAttack = 252;
            return;
        }

        this.specialAttack += specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void addSpecialDefense(int specialDefense) {
        if (getTotal() + specialDefense > 510) {
            specialDefense = getTotal() + specialDefense - 510;
            this.specialDefense += specialDefense;
            return;
        }

        if (this.specialDefense + specialDefense > 252) {
            this.specialDefense = 252;
            return;
        }

        this.specialDefense += specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void addSpeed(int speed) {
        if (getTotal() + speed > 510) {
            speed = getTotal() + speed - 510;
            this.speed += speed;
            return;
        }

        if (this.speed + speed > 252) {
            this.speed = 252;
            return;
        }

        this.speed += speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return this.hp + this.attack + this.defense + this.specialAttack + this.specialDefense + this.speed;
    }
}
