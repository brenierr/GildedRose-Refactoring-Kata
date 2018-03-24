package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

    Item item = new Item("foo", 1, 0);

	@Test
    public void testCreateItem() {
        assertEquals("foo", item.name);
        assertEquals(1, item.sellIn);
        assertEquals(0, item.quality);
    }
	
	@Test
	public void testToString() {
		assertEquals("foo, 1, 0", item.toString());
	}
}
