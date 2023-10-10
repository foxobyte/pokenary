package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

public class Medicine extends Item {
    public Medicine(String name) {
        super(ItemCategory.MEDICINE, name);
    }
}
