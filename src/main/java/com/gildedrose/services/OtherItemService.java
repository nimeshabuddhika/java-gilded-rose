package com.gildedrose.services;

import com.gildedrose.Item;
import com.gildedrose.factories.ItemFactory;

/**
 * @author Nimesha Buddhika on 6/27/2022 1:21 AM
 */
public class OtherItemService implements ItemFactory {
    @Override
    public void updateQuality(Item item) {
        checkMinQualityAndDecrease(item);
        decrementSelling(item);

        if (EXPIRY_DAYS > item.sellIn) {
            checkMinQualityAndDecrease(item);
        }
    }
}
