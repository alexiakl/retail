package com.challenge.retail.model.bill;

import java.util.ArrayList;

import com.challenge.retail.dao.BillDao;
import com.challenge.retail.model.item.Item;
import com.challenge.retail.model.user.User;

public class Bill {
  private ArrayList<Item> items = new ArrayList<>();
  private double finalTotal = 0;
  private double originalTotal = 0;
  private double discountTotal = 0;
  private double discountEvery = 0;
  private double discountEveryAmount = 0;
  private User user;
  
	public Bill(ArrayList<Item> items, User user) {
		this.items = items;
		this.user = user;
		
		this.discountEvery = BillDao.getDiscountEvery();
		this.discountEveryAmount = BillDao.getDiscountEveryAmount();
	}
	
	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the finalTotal
	 */
	public double getFinalTotal() {
		return finalTotal;
	}
	/**
	 * @param finalTotal the finalTotal to set
	 */
	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}
	/**
	 * @return the originalTotal
	 */
	public double getOriginalTotal() {
		return originalTotal;
	}
	/**
	 * @param originalTotal the originalTotal to set
	 */
	public void setOriginalTotal(double originalTotal) {
		this.originalTotal = originalTotal;
	}

	/**
	 * @return the discountTotal
	 */
	public double getDiscountTotal() {
		return discountTotal;
	}

	/**
	 * @param discountTotal the discountTotal to set
	 */
	public void setDiscountTotal(double discountTotal) {
		this.discountTotal = discountTotal;
	}

	/**
	 * @return the discountEvery
	 */
	public double getDiscountEvery() {
		return discountEvery;
	}

	/**
	 * @param discountEvery the discountEvery to set
	 */
	public void setDiscountEvery(double discountEvery) {
		this.discountEvery = discountEvery;
	}

	/**
	 * @return the discountEveryAmount
	 */
	public double getDiscountEveryAmount() {
		return discountEveryAmount;
	}

	/**
	 * @param discountEveryAmount the discountEveryAmount to set
	 */
	public void setDiscountEveryAmount(double discountEveryAmount) {
		this.discountEveryAmount = discountEveryAmount;
	}
}
