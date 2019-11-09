/**
 * 
 */
package com.robolverap.impl.bo.security;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.security.SecurityBo;
import com.robolverap.dao.security.FuncionDao;
import com.robolverap.dao.security.UsuarioDao;
import com.robolverap.exceptions.SecurityException;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;
import com.robolverap.web.security.ecrypt.SHA256Util;

/**
 * @author jrobolvp
 *
 */
@Service("securityBo")
@Transactional(readOnly = true)
public class SecurityBoImpl implements SecurityBo {
	
	@Autowired
    @Qualifier("usuarioDao")
    UsuarioDao<Usuario> usuarioDao;
	
	@Autowired
    @Qualifier("funcionDao")
    FuncionDao<Funcion> funcionDao;
	

	@Override
	public Boolean validateLogin(String claveUser, String password) throws SecurityException {
		Usuario usr = this.usuarioDao.findBy("clave", claveUser);
		if(usr == null){
			throw new SecurityException("User not found: "+claveUser);
		}
		return SHA256Util.encodeToSha256(password).equals(usr.getContraseña());
	}

	@Override
	public Boolean userCanAccess(Usuario usr, String opcion) {
		Usuario usrAux = usuarioDao.findBy("clave", usr.getClave());
		Set<Funcion> funciones = usrAux.getRol().getFunciones();
		List<Funcion> funcList = new ArrayList<Funcion>(funciones);
		return funcList.contains(this.funcionDao.findBy("url", opcion
				.replaceAll(SystemValues.DEFAULT_SUFIX.toString(), "")
				.replaceAll(SystemValues.DEFAULT_MTTO.toString(), "")));
	}

	@Override
	public String encodePassword(String password) {
		return SHA256Util.encodeToSha256(password);
	}

	@Override
	public String generaToken() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
	

}
