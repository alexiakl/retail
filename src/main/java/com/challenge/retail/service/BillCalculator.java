package com.challenge.retail.service;

import java.util.List;

import com.challenge.retail.model.bill.Bill;
import com.challenge.retail.model.item.Item;

public class BillCalculator {

	public static double execute(Bill bill) {
		double finalTotal = 0;
		double originalTotal = 0;
		double totalWithRatioDiscounts = 0;
		double totalWithoutRatioDiscounts = 0;

		List<Item> items =  bill.getItems();
		for (Item item : items) {
			originalTotal += item.getPrice();
			if (item.isDiscountable()) {
				totalWithRatioDiscounts += item.getPrice();
			}
			else {
				totalWithoutRatioDiscounts += item.getPrice();
			}
		}

		double ratio = bill.getUser().getDiscount();
		double every = bill.getDiscountEvery();
		if (ratio > 0) {
			totalWithRatioDiscounts *= (1.0-ratio);
			finalTotal = totalWithRatioDiscounts + totalWithoutRatioDiscounts;

		}
		if (every > 0) {
			double amount = bill.getDiscountEveryAmount();
			double tempTotal = totalWithRatioDiscounts + totalWithoutRatioDiscounts;
			int multiplier = (int) (tempTotal/every);
			finalTotal = tempTotal - (multiplier * amount);
		}
		
		bill.setOriginalTotal(originalTotal);
		bill.setFinalTotal(finalTotal);
		bill.setDiscountTotal(originalTotal - finalTotal);
		return finalTotal;
	}
}
