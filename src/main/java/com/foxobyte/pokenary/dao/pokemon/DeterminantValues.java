package com.foxobyte.pokenary.dao.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "determinant_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeterminantValues implements IStatValues {
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
