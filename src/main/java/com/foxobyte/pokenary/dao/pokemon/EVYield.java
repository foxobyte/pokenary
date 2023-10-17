package com.foxobyte.pokenary.dao.pokemon;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ev_yields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EVYield {
    @Id
    @GeneratedValue
    private Long id;
    @JsonAlias({"HP"})
    private Integer hp;
    @JsonAlias({"Attack"})
    private Integer attack;
    @JsonAlias({"Defense"})
    private Integer defense;
    @JsonAlias({ "Sp. Atk" })
    private Integer specialAttack;
    @JsonAlias({ "Sp. Def" })
    private Integer specialDefense;
    @JsonAlias({"Speed"})
    private Integer speed;
}