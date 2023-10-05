package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class EvolutionStone extends Item implements IItem {

    public EvolutionStone(ItemCategory itemCategory) {
        super(itemCategory);
    }

    @Override
    public void use() {

    }
}
