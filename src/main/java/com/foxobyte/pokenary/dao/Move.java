package com.foxobyte.pokenary.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foxobyte.pokenary.constants.MoveCategory;
import com.foxobyte.pokenary.constants.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "moves")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Move {
    @Id
    @GeneratedValue
    @Column(name = "move_id")
    private Integer moveId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Type type;
    @Column(name = "category")
    private MoveCategory category;
    @Column(name = "power")
    private Integer power;
    @Column(name = "accuracy")
    private Integer accuracy;
    @Column(name = "pp")
    private Integer pp;
    @Column(name = "effect_description")
    private String effectDescription;
    @Column(name = "probability")
    private Float probability;
    @Column(name = "is_high_crit")
    private boolean isHighCrit;
}
