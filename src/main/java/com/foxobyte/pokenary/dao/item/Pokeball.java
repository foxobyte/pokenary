package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

public class Pokeball extends Item {
    private Float catchRate;

    public Pokeball(String name, Float catchRate) {
        super(ItemCategory.POKEBALL, name);

        this.catchRate = catchRate;
    }
}
