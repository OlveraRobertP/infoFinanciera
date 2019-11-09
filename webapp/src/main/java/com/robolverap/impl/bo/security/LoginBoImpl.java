/**
 * 
 */
package com.robolverap.impl.bo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.security.LoginBo;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.dao.security.UsuarioDao;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
@Service("loginBo")
@Transactional(readOnly = true)
public class LoginBoImpl implements LoginBo {
	
	@Autowired
    @Qualifier("usuarioDao")
    UsuarioDao<Usuario> usuarioDao;
	
	@Autowired
    @Qualifier("bitacoraDao")
	BitacoraDao<Bitacora> bitacoraDao;

	@Override
	@Transactional(readOnly = false)
	public void setUltimoAcceso(Usuario usuario) {
		usuario.setUltimoAcceso(new Date());
		usuarioDao.saveOrUpdate(usuario);
	}

}
