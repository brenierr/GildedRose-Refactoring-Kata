package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "foo", 50, 0, 48, -1 }, { "foo", 50, -1, 48, -2 },
                { "foo", -1, -1, -1, -2 }, { GildedRose.AGED_BRIE, 0, 0, 2, -1 },
                { GildedRose.AGED_BRIE, 50, 0, 50, -1 }, 
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 1, 1, 4, 0 },
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 50, -1, 0, -2 },
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 1, 8, 3, 7 },
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 1, 11, 2, 10 },
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 49, 5, 50, 4 },
                { GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, -1, -1, 0, -2 },
                { GildedRose.SULFURAS_HAND_OF_RAGNAROS, 0, 0, 0, 0 }, { GildedRose.SULFURAS_HAND_OF_RAGNAROS, 1, 1, 1, 1 },
                { GildedRose.SULFURAS_HAND_OF_RAGNAROS, 50, -1, 50, -1 }
        });
    }

    private final String itemName;
    private final int itemInitialQuality;
    private final int itemInitialSellIn;
    private final int itemExpectedQuality;
    private final int itemExpectedSellIn;
 
    public GildedRoseTest(String itemName, 
                                  int itemInitialQuality, 
                                  int itemInitialSellIn,
                                  int itemExpectedQuality, 
                                  int itemExpectedSellIn) {
        this.itemName = itemName;
        this.itemInitialQuality = itemInitialQuality;
        this.itemInitialSellIn = itemInitialSellIn;
        this.itemExpectedQuality = itemExpectedQuality;
        this.itemExpectedSellIn = itemExpectedSellIn;
    }

    @Test
    public void shouldReturnQualityAndSellIn() {
        Item[] items = new Item[] { new Item(itemName, itemInitialSellIn, itemInitialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemExpectedQuality, app.getItem(0).getQuality());
        assertEquals(itemExpectedSellIn, app.getItem(0).getSellIn());
    }
}
