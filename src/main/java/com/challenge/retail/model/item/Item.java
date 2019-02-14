package com.challenge.retail.model.item;

import java.util.UUID;

import com.challenge.retail.dao.ItemDao;
import com.challenge.retail.model.item.ItemType;

public class Item {
    private String itemId;
    private String itemName;
    private ItemType itemType;
    private double price = 0;
    private boolean isDiscountable = false;
    
		/**
		 * @param itemName
		 * @param itemType
		 * @param price
		 */
		public Item(String itemName, ItemType itemType, double price) {
			this.itemId = UUID.randomUUID().toString();
			this.itemName = itemName;
			this.itemType = itemType;
			this.price = price;
			this.isDiscountable = ItemDao.getIsDiscountable(itemType);
		}

		/**
		 * @return the itemId
		 */
		public String getItemId() {
			return itemId;
		}
		/**
		 * @param itemId the itemId to set
		 */
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
		/**
		 * @return the itemName
		 */
		public String getItemName() {
			return itemName;
		}
		/**
		 * @param itemName the itemName to set
		 */
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		/**
		 * @return the itemType
		 */
		public ItemType getItemType() {
			return itemType;
		}
		/**
		 * @param itemType the itemType to set
		 */
		public void setItemType(ItemType itemType) {
			this.itemType = itemType;
		}
		/**
		 * @return the price
		 */
		public double getPrice() {
			return price;
		}
		/**
		 * @param price the price to set
		 */
		public void setPrice(double price) {
			this.price = price;
		}

		/**
		 * @return the isDiscountable
		 */
		public boolean isDiscountable() {
			return isDiscountable;
		}

		/**
		 * @param isDiscountable the isDiscountable to set
		 */
		public void setDiscountable(boolean isDiscountable) {
			this.isDiscountable = isDiscountable;
		}
}
