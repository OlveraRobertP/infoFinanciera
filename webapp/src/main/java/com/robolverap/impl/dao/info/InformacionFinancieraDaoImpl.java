/**
 * 
 */
package com.robolverap.impl.dao.info;

import java.util.Calendar;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.robolverap.dao.info.InformacionFinancieraDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.InformacionFinanciera;

/**
 * @author jrobolvp
 *
 */

@Repository("infoFinanDao")
public class InformacionFinancieraDaoImpl extends PersistenceAppMainDaoImpl<InformacionFinanciera> 
implements InformacionFinancieraDao<InformacionFinanciera>{

	@Override
	public InformacionFinanciera findByCtaByPeriodo(Cuenta cuenta, Calendar ultimoDiaMes) {
		return (InformacionFinanciera) this.getSession()
				.createCriteria(InformacionFinanciera.class)
				.add(Restrictions.eq("cuenta", cuenta))
				.add(Restrictions.eq("fecha", ultimoDiaMes.getTime()))
				.uniqueResult();
	}

}

