/**
 * 
 */
package com.robolverap.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Operaciones comunes para fechas
 * 
 * @author jrobolvp
 *
 */
public class DateUtil {

	/**
	 * Retorna la cantidad de dias que tiene el mes
	 * 
	 * @param mes Mes seleccionado.
	 * @return
	 */
	public static Integer diasEnMes(Integer mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2010);
		calendar.set(Calendar.MONTH, mes - 1);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * Devuelve el utlimo dia del mes
	 * 
	 * @param base
	 * @return
	 */
	public static Calendar ultimoDiaMes(Date base) {
		Calendar c = Calendar.getInstance();
		c.setTime(base);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c;
	}

	/**
	 * Devuelve el utlimo dia del mes
	 * @param year
	 * @param month
	 * @return
	 */
	public static Calendar ultimoDiaMes(Integer year, Integer month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c;
	}
	
	/**
	 * Devuelve el primer dia del mes
	 * 
	 * @param base
	 * @return
	 */
	public static Calendar primerDiaMes(Date base) {
		Calendar c = Calendar.getInstance();
		c.setTime(base);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c;
	}

	/**
	 * Devuelve el primer dia del mes
	 * 
	 * 
	 * * @param year
	 * @param month comienza con 0
	 * @return
	 */
	public static Calendar primerDiaMes(Integer year, Integer month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.YEAR, year);	
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DAY_OF_MONTH,1);
		return c;
	}
}
