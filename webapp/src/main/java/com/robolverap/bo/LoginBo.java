package com.robolverap.bo;

import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
public interface LoginBo {

	/**
	 * Coloca el ultimo acceso al usuario.
	 * @param user
	 */
	void setUltimoAcceso(Usuario user);
	
	
}
