/**
 * 
 */
package com.robolverap.impl.dao.info;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.info.EstadoFinancieroDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.financieros.EstadoFinanciero;

/**
 * @author jrobolvp
 *
 */
@Repository("edoFinanDao")
public class EstadoFinancieroDaoImpl extends PersistenceAppMainDaoImpl<EstadoFinanciero> 
	implements EstadoFinancieroDao<EstadoFinanciero>{
	
}
