/**
 * 
 */
package com.robolverap.dao;

import java.util.List;

import com.robolverap.dao.factory.PersistenceDao;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Rol;

/**
 * @author Roberto Olvera
 *
 */
public interface FuncionDao<Funcion> extends PersistenceDao<Funcion>{
	
	/**
	 * Retorna las funciones asociadas a un rol y a un modulos
	 * @param us
	 * @param mod
	 * @return
	 */
	List<com.robolverap.model.app.security.Funcion> funcionesByUsuarioByModulo(Rol rol, Modulo mod);

	
}
