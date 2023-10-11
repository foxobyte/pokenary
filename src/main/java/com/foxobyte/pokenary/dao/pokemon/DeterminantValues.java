package com.foxobyte.pokenary.dao.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeterminantValues {
    @Id
    @GeneratedValue
    private Long id;
    @Min(0)
    @Max(15)
    private Integer hp;
    @Min(0)
    @Max(15)
    private Integer attack;
    @Min(0)
    @Max(15)
    private Integer defense;
    @Min(0)
    @Max(15)
    private Integer specialAttack;
    @Min(0)
    @Max(15)
    private Integer specialDefense;
    @Min(0)
    @Max(15)
    private Integer speed;
}
