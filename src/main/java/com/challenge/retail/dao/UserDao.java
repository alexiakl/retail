package com.challenge.retail.dao;

import java.util.Calendar;

import com.challenge.retail.model.user.UserType;
import com.challenge.retail.util.Utils;

public class UserDao {

	public static double getDiscount(UserType userType, long created) {
		double discount = 0;
    switch (userType) {
    case CUSTOMER:
        discount = 0;
        if (Utils.timeDifferenceInYears(Calendar.getInstance().getTimeInMillis(), created) >= 2) {
            discount = 0.05;
        }
        break;
    case AFFILIATE:
        discount = 0.1;
        break;

    case EMPLOYEE:
        discount = 0.3;
        break;
    default:
        discount = 0;
        break;
    }
    return discount;
	}

}
