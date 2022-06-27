package com.gildedrose.services;

import com.gildedrose.Item;
import com.gildedrose.factories.ItemFactory;

/**
 * @author Nimesha Buddhika on 6/27/2022 1:55 AM
 */
public class ConjuredService implements ItemFactory {
    private static final int CONJURED_QUALITY_DEPRECATION = 2;

    @Override
    public void updateQuality(Item item) {
        checkMinQualityAndDecrease(item);
        decrementSelling(item);

        if (EXPIRY_DAYS > item.sellIn) {
            checkMinQualityAndDecrease(item);
        }
    }

    @Override
    public void checkMinQualityAndDecrease(Item item) {
        if (MINIMUM_QUALITY < item.quality) {
            decrementQuality(item);
        }
    }

    @Override
    public void decrementQuality(Item item) {
        item.quality -= CONJURED_QUALITY_DEPRECATION;
    }
}
