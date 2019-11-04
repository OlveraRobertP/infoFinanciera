/**
 * 
 */
package com.robolverap.impl.dao;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.RolDao;
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
