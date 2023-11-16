package com.foxobyte.pokenary.dao.pokemon;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "individual_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualValues implements IStatValues {
    @Id
    @GeneratedValue
    private Long individualValuesId;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;
}
