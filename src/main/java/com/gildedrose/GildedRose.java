package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";

	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(i);
            updateItemSellIn(i);
        }
    }

	private void updateItemQuality(int i) {
		if (!items[i].getName().equals(AGED_BRIE)
		        && !items[i].getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
		    if (items[i].getQuality() > 0 && !items[i].getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
	            items[i].setQuality(items[i].getQuality() - 1);
		    }
		} else {
		    if (items[i].getQuality() < 50) {
		        items[i].setQuality(items[i].getQuality() + 1);

		        if (items[i].getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
		            if (items[i].getSellIn() < 11 && items[i].getQuality() < 50) {
	                    items[i].setQuality(items[i].getQuality() + 1);
		            }

		            if (items[i].getSellIn() < 6 && items[i].getQuality() < 50) {
	                    items[i].setQuality(items[i].getQuality() + 1);
		            }
		        }
		    }
		}

		if (items[i].getSellIn() < 1) {
		    if (!items[i].getName().equals(AGED_BRIE)) {
		        if (!items[i].getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
		            if (items[i].getQuality() > 0 && !items[i].getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
	                    items[i].setQuality(items[i].getQuality() - 1);
		            }
		        } else {
		            items[i].setQuality(0);
		        }
		    } else {
		        if (items[i].getQuality() < 50) {
		            items[i].setQuality(items[i].getQuality() + 1);
		        }
		    }
		}
	}

	private void updateItemSellIn(int i) {
		if (!items[i].getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
		    items[i].setSellIn(items[i].getSellIn() - 1);
		}
	}
    
    public Item getItem(int i) {
    	return this.items[i];
    }
}