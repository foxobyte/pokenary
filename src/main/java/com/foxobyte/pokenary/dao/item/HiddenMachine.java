package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

public class HiddenMachine extends Item {
    private Integer number;

    public HiddenMachine(String name, Integer number) {
        super(ItemCategory.MACHINE, name);

        this.number = number;
    }
}
