/**
 * 
 */
package com.robolverap.dao.info;

import java.util.List;

import com.robolverap.dao.factory.PersistenceDao;
import com.robolverap.model.app.financieros.EstadoFinanciero;

/**
 * @author jrobolvp
 *
 */
public interface CuentaDao <Cuenta> extends PersistenceDao<Cuenta>{

	List<com.robolverap.model.app.financieros.Cuenta> findByEdoFinanciero(EstadoFinanciero edoFinanciero);

}
