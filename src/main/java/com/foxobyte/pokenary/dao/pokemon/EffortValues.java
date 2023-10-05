package com.foxobyte.pokenary.dao.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Effort values are a thing that does stuff
 */
@Entity
@Table(name = "effort_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EffortValues {
    @Id
    @GeneratedValue
    private Long effortValueId;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;
}
