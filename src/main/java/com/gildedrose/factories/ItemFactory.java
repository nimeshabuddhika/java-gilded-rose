package com.gildedrose.factories;

import com.gildedrose.Item;

/**
 * @author Nimesha Buddhika on 6/26/2022 11:57 PM
 */
@FunctionalInterface
public interface ItemFactory {
    int MINIMUM_QUALITY = 0;
    int MAXIMUM_QUALITY = 50;
    int EXPIRY_DAYS = 0;

    /**
     * An item status can be determined by implementing <code>ItemFactory</code> interface
     * and overriding it's <code>updateQuality</code> method
     *
     *
     * @param item Item Object
     */
    void updateQuality(Item item);

    /**
     * Decrement selling value by one
     *
     * @param item Item Object
     */
    default void decrementSelling(Item item) {
        item.sellIn--;
    }

    /**
     * Item quality is grater than the minimum quality, then the item quality will be reduced if {@code MINIMUM_QUALITY < item.quality}
     *
     * @param item Item Object
     */
    default void checkMinQualityAndDecrease(Item item) {
        if (MINIMUM_QUALITY < item.quality) {
            decrementQuality(item);
        }
    }

    /**
     * Item quality is less than the maximum quality, then the item item quality will be increased if {@code MAXIMUM_QUALITY > item.quality}
     *
     * @param item Item Object
     */
    default void checkMaxQualityAndIncrease(Item item) {
        if (MAXIMUM_QUALITY > item.quality) {
            incrementQuality(item);
        }
    }

    /**
     * Decrease item quality value
     *
     * @param item Item Object
     */
    default void decrementQuality(Item item) {
        item.quality--;
    }

    /**
     * Increase item quality value
     *
     * @param item Item Object
     */
    default void incrementQuality(Item item) {
        item.quality++;
    }
}
