package com.foxobyte.pokenary.dao.item;

import com.foxobyte.pokenary.constants.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private ItemCategory category;
    private String name;

    public Item(ItemCategory category, String name) {
        this.category = category;
        this.name = name;
    }
}
