/**
 * 
 */
package com.robolverap.impl.dao.security;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.security.RolDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Rol;

/**
 * @author Roberto Olvera
 *
 */
@Repository("rolDao")
public class RolDaoImpl 
		extends PersistenceAppMainDaoImpl<Rol> 
		implements RolDao<Rol> {



}
