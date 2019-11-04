/**
 * 
 */
package com.robolverap.services;

import java.util.List;
import java.util.Map;

/**
 * @author jrobolvp
 *
 */
public interface CalendarService {

	/**
	 * Devuelve el un mapa ordenado k,v de meses en formato de internacionalizacion
	 * @return listado de meses en formato de internacionalizacion
	 */
	List<Integer> lastYears();

	/**
	 * Devuelve un listado de los ultimos 5 anios comenzando desde el actual
	 * @return
	 */
	Map<Integer, String> monthsOfYear();

}
