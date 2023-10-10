package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

public class TechnicalMachine extends Item {
    private Integer number;

    public TechnicalMachine(String name, Integer number) {
        super(ItemCategory.MACHINE, name);

        this.number = number;
    }
}
