package com.challenge.retail.dao;

import com.challenge.retail.model.item.ItemType;

public class ItemDao {

	public static boolean getIsDiscountable(ItemType itemType) {
		boolean isDiscountable = false;
		switch (itemType) {
		case GROCERIES:
			isDiscountable = false;
			break;

		default:
			isDiscountable = true;
			break;
		}
		
		return isDiscountable;
	}

}
