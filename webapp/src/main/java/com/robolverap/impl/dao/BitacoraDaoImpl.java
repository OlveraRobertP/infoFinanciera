/**
 * 
 */
package com.robolverap.impl.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.robolverap.dao.BitacoraDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.BitacoraEvento;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author Roberto Olvera
 *
 */
@Repository("bitacoraDao")
public class BitacoraDaoImpl 
		extends PersistenceAppMainDaoImpl<Bitacora> 
		implements BitacoraDao<Bitacora> {

	@Override
	public BitacoraEvento findEventoByClave(BitacoraEventClaves clave) {
		return (BitacoraEvento) this.getSession()
				.createCriteria(BitacoraEvento.class)
				.add(Restrictions.eq("clave", clave.toString()))
				.uniqueResult();
	}

}
