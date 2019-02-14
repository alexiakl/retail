package com.challenge.retail.util;

/**
 * Singleton class for Utilities
 * @author alexiakl
 *
 */
public class Utils {

    private static final Utils instance = new Utils();

    // private constructor to avoid client applications to use constructor
    private Utils() {
    }

    public static Utils getInstance() {
        return instance;
    }
    
		public static double timeDifferenceInYears(long time1, long time2) {
      long diff = Math.abs(time1 - time2);
      long seconds = diff / 1000;
      double hours = seconds / 3600;
      double days = hours / 24;
      double years = days / 365.25;
      return years;
		}
}
