/**
 * 
 */
package com.robolverap.dao.info;

import java.util.Calendar;

import com.robolverap.dao.factory.PersistenceDao;
import com.robolverap.model.app.financieros.Cuenta;

/**
 * @author jrobolvp
 *
 */
public interface InformacionFinancieraDao <InformacionFinanciera> extends PersistenceDao<InformacionFinanciera>{

	/**
	 * Devuelcve la informacion financiera de una cuenta para el periodo dado
	 * @param cta
	 * @param ultimoDiaMes
	 * @return
	 */
	com.robolverap.model.app.financieros.InformacionFinanciera findByCtaByPeriodo(Cuenta cta,
			Calendar ultimoDiaMes);

}
