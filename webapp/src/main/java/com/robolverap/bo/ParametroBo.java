/**
 * 
 */
package com.robolverap.bo;

import java.util.List;

import com.robolverap.model.app.security.Parametro;
import com.robolverap.model.app.security.Usuario;

/**
 * @author Roberto Olvera
 *
 */
public interface ParametroBo {
	
	/**
	 * Retorna un Parametro por su id
	 * @param id
	 * @return
	 */
	Parametro findById(Integer id);
	
	/**
	 * Retorna un Parametro por su clave
	 * @param clave
	 * @return
	 */
	Parametro findByClave(String clave);

	/**
	 * Devuelve todos los Parametroes
	 * 
	 * @return
	 */
	List<Parametro> findAll();

	/**
	 * Guarda o actualiza un Parametro y registra la accion en bitacora	
	 * @param entity Entidad del Parametro a guardar o actualizar
	 * @param usuario usuario que realiza la operacion
	 */
	void saveOrUpdate(Parametro entity, Usuario usuario);

	/**
	 * Elimina un Parametro  y registra la accion en bitacora
	 * @param entity registro a eliminar
	 * @param usuario usuario que realiza la operacion
	 */
	void delete(Parametro entity, Usuario usuario);
}
