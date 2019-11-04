/**
 * 
 */
package com.robolverap.bo;

import java.util.List;

import com.robolverap.model.app.security.Funcion;

/**
 * @author Roberto Olvera
 *
 */
public interface FuncionBo {
	
	/**
	 * Retorna una funcion por su clave
	 * @param clave
	 * @return
	 */
	Funcion findByClave(String clave);

	/**
	 * Devuelve todos las funciones
	 * 
	 * @return
	 */
	List<Funcion> findAll();

	/**
	 * Devuelve las funciones asociadas a un rol
	 * @param rolSelected
	 * @return
	 */
	List<Funcion> findByCveRol(String rolSelected);
}
