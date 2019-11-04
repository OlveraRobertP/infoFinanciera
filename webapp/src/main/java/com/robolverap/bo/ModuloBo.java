/**
 * 
 */
package com.robolverap.bo;

import java.util.List;

import com.robolverap.model.app.security.Modulo;

/**
 * @author Roberto Olvera
 *
 */
public interface ModuloBo {
	
	/**
	 * Retorna un modulo por su clave
	 * @param clave
	 * @return
	 */
	Modulo findByClave(String clave);

	/**
	 * Devuelve todos los modulo
	 * 
	 * @return
	 */
	List<Modulo> findAll();
}
