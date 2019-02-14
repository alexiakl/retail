package com.challenge.retail.model.user;

import java.util.UUID;

import com.challenge.retail.dao.UserDao;
import com.challenge.retail.model.bill.Bill;
import com.challenge.retail.model.user.UserType;

public class User {
    private String userId;
    private String username;
    private UserType userType;
    private Bill bill;
    private double discount = 0;
    private long created;

    public User(String username, UserType userType, long created) {
      this.userId = UUID.randomUUID().toString();
      this.username = username;
      this.userType = userType;
      this.created = created;
      this.discount = UserDao.getDiscount(userType, created);
    }

		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * @return the userType
		 */
		public UserType getUserType() {
			return userType;
		}

		/**
		 * @param userType the userType to set
		 */
		public void setUserType(UserType userType) {
			this.userType = userType;
		}

		/**
		 * @return the bill
		 */
		public Bill getBill() {
			return bill;
		}

		/**
		 * @param bill the bill to set
		 */
		public void setBill(Bill bill) {
			this.bill = bill;
		}

		/**
		 * @return the discount
		 */
		public double getDiscount() {
			return discount;
		}

		/**
		 * @param discount the discount to set
		 */
		public void setDiscount(double discount) {
			this.discount = discount;
		}

		/**
		 * @return the created
		 */
		public long getCreated() {
			return created;
		}

		/**
		 * @param created the created to set
		 */
		public void setCreated(long created) {
			this.created = created;
		}    
}
