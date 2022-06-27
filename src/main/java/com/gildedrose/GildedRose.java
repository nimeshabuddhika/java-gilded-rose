package com.gildedrose;

import com.gildedrose.factories.ItemFactory;
import com.gildedrose.services.*;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        ItemFactory factory;
        switch (item.name) {
            case AGED_BRIE:
                factory = new AgedBrieService();
                break;
            case BACKSTAGE_PASSES:
                factory = new BackstageService();
                break;
            case SULFURAS_HAND:
                factory = new SulfurasService();
                break;
            case CONJURED_MANA_CAKE:
                factory = new ConjuredService();
                break;
            default:
                factory = new OtherItemService();
                break;
        }
        factory.updateQuality(item);
    }

}
