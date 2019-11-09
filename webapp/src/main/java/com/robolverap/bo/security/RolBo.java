/**
 * 
 */
package com.robolverap.bo.security;

import java.util.List;

import com.robolverap.model.app.security.Rol;
import com.robolverap.model.app.security.Usuario;

/**
 * @author Roberto Olvera
 *
 */
public interface RolBo {
	
	/**
	 * Retorna un rol por su clave
	 * @param clave
	 * @return
	 */
	Rol findByClave(String clave);

	/**
	 * Devuelve todos los roles
	 * 
	 * @return
	 */
	List<Rol> findAll();

	/**
	 * Guarda o actualiza un rol y registra la accion en bitacora	
	 * @param entity Entidad del rol a guardar o actualizar
	 * @param usuario usuario que realiza la operacion
	 */
	void saveOrUpdate(Rol entity, Usuario usuario);

	/**
	 * Elimina un rol  y registra la accion en bitacora
	 * @param entity registro a eliminar
	 * @param usuario usuario que realiza la operacion
	 */
	void delete(Rol entity, Usuario usuario);
}
