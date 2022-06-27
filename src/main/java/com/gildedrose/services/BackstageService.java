package com.gildedrose.services;

import com.gildedrose.Item;
import com.gildedrose.factories.ItemFactory;

/**
 * @author Nimesha Buddhika on 6/26/2022 11:59 PM
 */
public class BackstageService implements ItemFactory {
    private static final int BIG_SELLING_DATE = 11;
    private static final int LESS_SELLING_DATE = 6;
    private static final int NO_QUALITY = 0;

    @Override
    public void updateQuality(Item item) {
        if (MAXIMUM_QUALITY > item.quality) {
            incrementQuality(item);

            if (BIG_SELLING_DATE > item.sellIn) {
                checkMaxQualityAndIncrease(item);
            }

            if (LESS_SELLING_DATE > item.sellIn) {
                checkMaxQualityAndIncrease(item);
            }
        }

        decrementSelling(item);

        if (EXPIRY_DAYS > item.sellIn) {
            item.quality = NO_QUALITY;
        }
    }
}
