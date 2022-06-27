package com.gildedrose.services;

import com.gildedrose.Item;
import com.gildedrose.factories.ItemFactory;

/**
 * @author Nimesha Buddhika on 6/26/2022 11:58 PM
 */
public class AgedBrieService implements ItemFactory {
    @Override
    public void updateQuality(Item item) {
        checkMaxQualityAndIncrease(item);
        decrementSelling(item);
        if (EXPIRY_DAYS > item.sellIn) {
            checkMaxQualityAndIncrease(item);
        }
    }
}
