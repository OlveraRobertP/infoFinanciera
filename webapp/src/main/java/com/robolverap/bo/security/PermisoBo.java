/**
 * 
 */
package com.robolverap.bo.security;

import java.util.List;

import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Usuario;



/**
 * 
 * Operaciones relacionadas a los privilegios de los usuarios
 * @author jrobolvp
 *
 */
public interface PermisoBo {

	/** 
	 * Retorna el listado de funciones a las que tiene permiso el usuario.
	 * @param usr
	 * @return
	 */
	List<Funcion> funcionesByUsuario(Usuario usr);

	/**
	 * Retorna el listado de modulos a los que tiene acceso un usario
	 * @param usr
	 * @return
	 */
	List<Modulo> modulosByUsuario(Usuario usr);

	
	/** 
	 * Devuelve el menu que concida con la clave
	 * @param clave La clave del menu a buscar
	 * @return
	 */
	Modulo moduloByClave(String clave);

	
	/**
	 * Asigana las funciones al rol seleccionado
	 * @param cveRol Clave del rol seleccionado
	 * @param funciones Funciones a asignar por el rol
	 */
	void asignarPrivilegios(String cveRol, List<Funcion> funciones);

	/**
	 * Retorna las funciones de un modulo a las cuales tiene acceso el usuario
	 * @param us
	 * @param mod
	 * @return
	 */
	List<Funcion> funcionesByUsuarioByModulo(Usuario us, Modulo mod);

}
