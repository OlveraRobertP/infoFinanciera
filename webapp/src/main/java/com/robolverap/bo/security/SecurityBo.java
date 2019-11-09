package com.robolverap.bo.security;

import com.robolverap.exceptions.SecurityException;
import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
public interface SecurityBo {
	
	/**
	 * Valida que el usuario y la contrasena correspondan a un usario valido
	 * @param claveUser
	 * @param password
	 * @return
	 * @throws SecurityException 
	 */
	Boolean validateLogin(String claveUser, String password) throws SecurityException;

	/**
	 * Valida que el usuario tenga acceso a la opcion solicitado
	 * @param usr
	 * @param opcion
	 * @return
	 */
	Boolean userCanAccess(Usuario usr, String opcion);

	/**
	 * Encripta la contrasena
	 * @param password
	 * @return
	 */
	String encodePassword(String password);
	
	/**
	 * Genera un token dinamico para realizar la validacion de seguridad
	 * @return
	 */
	String generaToken();
}
