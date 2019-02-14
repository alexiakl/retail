package com.challenge.retail.bills;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import com.challenge.retail.model.bill.Bill;
import com.challenge.retail.model.item.Item;
import com.challenge.retail.model.item.ItemType;
import com.challenge.retail.model.user.User;
import com.challenge.retail.model.user.UserType;
import com.challenge.retail.service.BillCalculator;

public class BillTests {
	@Test
	public void userDiscountsTest() {
		long now = Calendar.getInstance().getTimeInMillis();
		Calendar pastCal = Calendar.getInstance();
		pastCal.set(Calendar.YEAR, 2010);
		long past = pastCal.getTimeInMillis();
		User customerNew = new User("Alexi Akl", UserType.CUSTOMER, now);
		User customerOld = new User("Dominique Akl", UserType.CUSTOMER, past);
		User affliate = new User("Angela Akl", UserType.AFFILIATE, now);
		User affliateOld = new User("Dominique Akl", UserType.AFFILIATE, past);
		User employee = new User("Joseph Akl", UserType.EMPLOYEE, now);
		User employeeOld = new User("Angel Akl", UserType.EMPLOYEE, past);

		assertTrue(customerNew.getDiscount() == 0);
		assertTrue(customerOld.getDiscount() == 0.05);
		assertTrue(affliate.getDiscount() == 0.1);
		assertTrue(affliateOld.getDiscount() == 0.1);
		assertTrue(employee.getDiscount() == 0.3);
		assertTrue(employeeOld.getDiscount() == 0.3);
	}
	
	@Test
	public void oldEmployeeDiscountTest() {
		Calendar pastCal = Calendar.getInstance();
		pastCal.set(Calendar.YEAR, 2010);
		long past = pastCal.getTimeInMillis();
		User user = new User("Alexi Akl", UserType.EMPLOYEE, past);
		
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item("Apples", ItemType.GROCERIES, 150);
		Item item2 = new Item("Oranges", ItemType.GROCERIES, 75); 
		Item item3 = new Item("Earrings", ItemType.ACCESSORIES, 75);
		Item item4 = new Item("Phone", ItemType.ELECTRONICS, 375);
		// non discountable = 225
		// percentage discountable = 450
		// discount = 30%
		// 225 + (450 * 0.7) = 540
		// 5$ discount on every 100$, 540 - (5*5) 
		// total should be 515
		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Bill bill = new Bill(items, user);
		double total = BillCalculator.execute(bill);
		assertTrue(total == 515);
	}
	
	@Test
	public void oldCustomerDiscountTest() {
		Calendar pastCal = Calendar.getInstance();
		pastCal.set(Calendar.YEAR, 2010);
		long past = pastCal.getTimeInMillis();
		User user = new User("Alexi Akl", UserType.CUSTOMER, past);
		
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item("Apples", ItemType.GROCERIES, 150);
		Item item2 = new Item("Oranges", ItemType.GROCERIES, 75);
		Item item3 = new Item("Earrings", ItemType.ACCESSORIES, 75);
		Item item4 = new Item("Phone", ItemType.ELECTRONICS, 375);
		// non discountable = 225
		// percentage discountable = 450
		// discount = 5%
		// 225 + (450 * 0.95) = 652.5
		// 5$ discount on every 100$, 652.5 - (6*5) 
		// total should be 622.5
		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Bill bill = new Bill(items, user);
		double total = BillCalculator.execute(bill);
		assertTrue(total == 622.5);
	}
	
	@Test
	public void newCustomerDiscountTest() {
		User user = new User("Alexi Akl", UserType.CUSTOMER, Calendar.getInstance().getTimeInMillis());
		
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item("Apples", ItemType.GROCERIES, 150);
		Item item2 = new Item("Oranges", ItemType.GROCERIES, 75); 
		Item item3 = new Item("Earrings", ItemType.ACCESSORIES, 75);
		Item item4 = new Item("Phone", ItemType.ELECTRONICS, 375);
		// non discountable = 225
		// percentage discountable = 450
		// no discount
		// 225 + 450 = 675
		// 5$ discount on every 100$, 675 - (6*5) 
		// total should be 645
		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Bill bill = new Bill(items, user);
		double total = BillCalculator.execute(bill);
		assertTrue(total == 645);
	}
	
	@Test
	public void affiliateDiscountTest() {
		User user = new User("Alexi Akl", UserType.AFFILIATE, Calendar.getInstance().getTimeInMillis());
		
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item("Apples", ItemType.GROCERIES, 150);
		Item item2 = new Item("Oranges", ItemType.GROCERIES, 75);
		Item item3 = new Item("Earrings", ItemType.ACCESSORIES, 75);
		Item item4 = new Item("Phone", ItemType.ELECTRONICS, 375); 
		// non discountable = 225
		// percentage discountable = 450
		// discount = 10%
		// 225 + (450 * 0.9) = 630
		// 5$ discount on every 100$, 630 - (6*5) 
		// total should be 600
		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Bill bill = new Bill(items, user);
		double total = BillCalculator.execute(bill);
		assertTrue(total == 600);
	}
	
	@Test
	public void affiliateGroceriesDiscountTest() {
		User user = new User("Alexi Akl", UserType.AFFILIATE, Calendar.getInstance().getTimeInMillis());
		
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item("Apples", ItemType.GROCERIES, 150);
		Item item2 = new Item("Oranges", ItemType.GROCERIES, 75);
		Item item3 = new Item("Eggplants", ItemType.GROCERIES, 75);
		Item item4 = new Item("Lemons", ItemType.GROCERIES, 375); 
		// non discountable = 675
		// 5$ discount on every 100$, 675 - (6*5) 
		// total should be 645
		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Bill bill = new Bill(items, user);
		double total = BillCalculator.execute(bill);
		assertTrue(total == 645);
	}
}
