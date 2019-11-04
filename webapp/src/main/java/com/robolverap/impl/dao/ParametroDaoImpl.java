/**
 * 
 */
package com.robolverap.impl.dao;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.ParametroDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Parametro;

/**
 * @author Roberto Olvera
 *
 */
@Repository("parametroDao")
public class ParametroDaoImpl 
		extends PersistenceAppMainDaoImpl<Parametro> 
		implements ParametroDao<Parametro> {



}
