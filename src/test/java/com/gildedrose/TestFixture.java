package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFixture {


    @Test
    void fixed() {

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            //new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        Approvals.verify(Arrays.toString(app.items));
    }

    @Test
    void conjuredItem() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 3, 6)});

        app.updateQuality();

        assertEquals(app.items[0].toString(), new Item("Conjured Mana Cake", 2, 4).toString());
    }

}
