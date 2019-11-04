/**
 * 
 */
package com.robolverap.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Se formatean fechas
 * @author jrobolvp
 *
 */
public class DateFormat {
	
	private static SimpleDateFormat sdfFull = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy", new Locale("es", "MX"));
	
	private static SimpleDateFormat sdfMedium = new SimpleDateFormat("MMMMM 'de' yyyy", new Locale("es", "MX"));
	
	/**
	 * Formatea una fecha en formato dd 'de' MMMMM 'de' yyyy con locale new Locale("es", "MX")
	 * @param month
	 * @param year
	 * @return
	 */
	public static String formatFull(Integer month,Integer year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return sdfFull.format(calendar.getTime());
	}

	/**
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public static String formatMedium(Integer month, Integer year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return sdfMedium.format(calendar.getTime());
	}

	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatMedium(Calendar calendar) {
		return sdfMedium.format(calendar.getTime());
	}
	
	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatFull(Calendar calendar) {
		return sdfFull.format(calendar.getTime());
	}
}
