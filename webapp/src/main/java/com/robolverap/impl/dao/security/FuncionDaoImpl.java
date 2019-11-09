/**
 * 
 */
package com.robolverap.impl.dao.security;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.robolverap.dao.security.FuncionDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Rol;

/**
 * @author Roberto Olvera
 *
 */
@Repository("funcionDao")
public class FuncionDaoImpl 
		extends PersistenceAppMainDaoImpl<Funcion> 
		implements FuncionDao<Funcion> {

	

	@Override
	public List<Funcion> funcionesByUsuarioByModulo(Rol rol, Modulo mod) {
		return (List<Funcion>) this.getSession()
					.createCriteria(Funcion.class)
					.add(Restrictions.eq("modulo", mod))
					.createAlias("roles", "rolesAlias")
					.add(Restrictions.eq("rolesAlias.clave",rol.getClave()))
					.addOrder( Order.asc("orden") )
					.list();
	}

	


}
