/**
 * 
 */
package com.robolverap.dao;

import com.robolverap.dao.factory.PersistenceDao;
import com.robolverap.model.app.security.BitacoraEvento;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author Roberto Olvera
 *
 */
public interface BitacoraDao<Bitacora> extends PersistenceDao<Bitacora>{

	/**
	 * 
	 * Devueve un evento que corresponda con la clave
	 * @param clave Clave del evento a buscar
	 * @return
	 */
	BitacoraEvento findEventoByClave(BitacoraEventClaves clave);
	
}
