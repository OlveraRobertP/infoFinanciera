package com.robolverap.impl.dao.info;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.robolverap.dao.info.CuentaDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.financieros.InformacionFinanciera;

/**
 * 
 * @author jrobolvp
 *
 */
@Repository("cuentaDao")
public class CuentaDaoImpl extends PersistenceAppMainDaoImpl<Cuenta> 
implements CuentaDao<Cuenta>{

	@Override
	public List<Cuenta> findByEdoFinanciero(EstadoFinanciero edoFinanciero) {
		return  this.getSession()
				.createCriteria(Cuenta.class)
				.add(Restrictions.eq("edoFinanciero", edoFinanciero))
				.list();
	}

}
