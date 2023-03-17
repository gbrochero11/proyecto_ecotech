/**
 * 
 */
package com.graphisoft.ecotech.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author JeisonGaleano
 *
 */
public class Time {

	public static Timestamp getTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getTimeFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(System.currentTimeMillis());
		return strDate;
	}
}
