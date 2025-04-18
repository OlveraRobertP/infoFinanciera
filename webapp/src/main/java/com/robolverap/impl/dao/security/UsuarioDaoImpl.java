/**
 * 
 */
package com.robolverap.impl.dao.security;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.security.UsuarioDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.security.Usuario;

/**
 * @author Roberto Olvera
 *
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl 
		extends PersistenceAppMainDaoImpl<Usuario> 
		implements UsuarioDao<Usuario> {



}
