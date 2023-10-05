package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {
    @Id
    @GeneratedValue
    private Integer itemId;
    private ItemCategory itemCategory;

    public Item(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
