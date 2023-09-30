package com.foxobyte.pokenary.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonAlias({"national_number"})
    private Integer nationalNumber;
    private String name;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    @JsonAlias({"spAttack", "spAtk"})
    private Integer specialAttack;
    @JsonAlias({"spDefense", "spDef"})
    private Integer specialDefense;
    private Integer speed;
}
