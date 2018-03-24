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
                { "foo", -1, -1, -1, -2 }, { "Aged Brie", 0, 0, 2, -1 },
                { "Aged Brie", 50, 0, 50, -1 }, 
                { "Backstage passes to a TAFKAL80ETC concert", 1, 1, 4, 0 },
                { "Backstage passes to a TAFKAL80ETC concert", 50, -1, 0, -2 },
                { "Backstage passes to a TAFKAL80ETC concert", 1, 8, 3, 7 },
                { "Backstage passes to a TAFKAL80ETC concert", 1, 11, 2, 10 },
                { "Backstage passes to a TAFKAL80ETC concert", 49, 5, 50, 5 },
                { "Backstage passes to a TAFKAL80ETC concert", -1, -1, 0, -2 },
                { "Sulfuras, Hand of Ragnaros", 0, 0, 0, 0 }, { "Sulfuras, Hand of Ragnaros", 1, 1, 1, 1 },
                { "Sulfuras, Hand of Ragnaros", 50, -1, 50, -1 }
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
