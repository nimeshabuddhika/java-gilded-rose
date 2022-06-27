package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /**
     * 64 number of test cases
     */
    @Test
    void allCombinations() {
        String[] name = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer[] sellIn = {-1, 0, 5, 12};
        Integer[] quality = {0, 1, 49, 55};

        CombinationApprovals.verifyAllCombinations(this::updateQuality, name, sellIn, quality);
    }

    private String updateQuality(String name, int sellIn, int quality) {
        GildedRose app = new GildedRose(new Item[]{new Item(name, sellIn, quality)});
        app.updateQuality();
        return app.items[0].toString();
    }

    @Test
    void conjuredTwiceSpeed() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 3, 10)});

        app.updateQuality();

        assertEquals(app.items[0].toString(), new Item("Conjured Mana Cake", 2, 8).toString());
    }

    @Test
    void conjuredTwiceSpeedAndOutOfStock() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 0, 10)});

        app.updateQuality();

        assertEquals(app.items[0].toString(), new Item("Conjured Mana Cake", -1, 6).toString());
    }

    @Test
    void conjuredTwiceSpeedAndZeroQuality() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 0, 0)});

        app.updateQuality();

        assertEquals(app.items[0].toString(), new Item("Conjured Mana Cake", -1, 0).toString());
    }

}
