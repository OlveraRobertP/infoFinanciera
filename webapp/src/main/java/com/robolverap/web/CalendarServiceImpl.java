/**
 * 
 */
package com.robolverap.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.robolverap.services.CalendarService;

/**
 * @author jrobolvp
 *
 */
@Service("calendarService")
public class CalendarServiceImpl implements CalendarService{
	

	@Override
	public Map<Integer,String> monthsOfYear(){
		Map<Integer,String> months = new TreeMap<Integer,String>();
		months.put(1, "global.lbl.enero");
		months.put(2, "global.lbl.febrero");
		months.put(3, "global.lbl.marzo");
		months.put(4, "global.lbl.abril");
		months.put(5, "global.lbl.mayo");
		months.put(6, "global.lbl.junio");
		months.put(7, "global.lbl.julio");
		months.put(8, "global.lbl.agosto");
		months.put(9, "global.lbl.septiembre");
		months.put(10, "global.lbl.octubre");
		months.put(11, "global.lbl.noviembre");
		months.put(12, "global.lbl.diciembre");
		return months;
	}
	
	
	@Override
	public List<Integer> lastYears(){
		List<Integer> years = new ArrayList<Integer>();
		Calendar today = Calendar.getInstance();
		for(int i = today.get(Calendar.YEAR); 
				i > today.get(Calendar.YEAR) - 5 ; i--) {
			years.add(i);
		}
		return years;
	}
}
