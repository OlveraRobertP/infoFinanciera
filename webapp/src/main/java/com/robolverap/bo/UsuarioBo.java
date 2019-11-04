/**
 * 
 */
package com.robolverap.bo;

import java.util.List;

import javax.mail.MessagingException;

import com.robolverap.model.app.security.Usuario;

/**
 * @author Roberto Olvera
 *
 */
public interface UsuarioBo {
	
	/**
	 * Retorna un usuario por su clave
	 * @param clave
	 * @return
	 */
	Usuario findByClave(String clave);

	/**
	 * Devuelve todos los usuarios
	 * 
	 * @return
	 */
	List<Usuario> findAll();

	/**
	 * Guarda o actualiza un usuario
	 * @param usuario
	 * @param userInSession
	 */
	void saveOrUpdate(Usuario usuario, Usuario userInSession);

	/**
	 * Elimina un usuario
	 * @param usuario Usuario a ser borrado
	 * @param userInSession Usuario que registra la operacion
	 */
	void delete(Usuario usuario, Usuario userInSession);
	
	/**
	 * Resetea la contrasena del  @param usuario
	 * @param usuario Usuario a resetar contrasena
	 * @param userInSession usuario que registra la operacion
	 * @throws MessagingException 
	 */
	void resetPassword(Usuario usuario, Usuario userInSession) throws MessagingException;
}
