package com.foxobyte.pokenary.dao.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "stats_experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatExperience {
    @Id
    @GeneratedValue
    private Long id;
    @Min(0)
    @Max(65535)
    private int hp;
    @Min(0)
    @Max(65535)
    private int attack;
    @Min(0)
    @Max(65535)
    private int defense;
    @Min(0)
    @Max(65535)
    private int specialAttack;
    @Min(0)
    @Max(65535)
    private int specialDefense;
    @Min(0)
    @Max(65535)
    private int speed;
}
