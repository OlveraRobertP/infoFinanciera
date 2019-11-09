/**
 * 
 */
package com.robolverap.impl.dao.security;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.security.ModuloDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Usuario;

/**
 * @author Roberto Olvera
 *
 */
@Repository("moduloDao")
public class ModuloDaoImpl 
		extends PersistenceAppMainDaoImpl<Modulo> 
		implements ModuloDao<Modulo> {
	
	@Override
	public List<Modulo> findAll() {
		return this.getSession().createQuery("From Modulo mo order by mo.orden").list();
	}

}
