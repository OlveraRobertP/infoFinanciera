/**
 * 
 */
package com.robolverap.impl.bo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.PermisoBo;
import com.robolverap.dao.FuncionDao;
import com.robolverap.dao.ModuloDao;
import com.robolverap.dao.RolDao;
import com.robolverap.dao.UsuarioDao;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Rol;
import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
@Service("permisoBo")
@Transactional(readOnly = true)
public class PermisoBoImpl implements PermisoBo {
	
	@Autowired
    @Qualifier("usuarioDao")
    UsuarioDao<Usuario> usuarioDao;
	
	@Autowired
    @Qualifier("funcionDao")
	FuncionDao<Funcion> funcionDao;
	
	@Autowired
    @Qualifier("moduloDao")
	ModuloDao<Modulo> moduloDao;
	
	@Autowired
    @Qualifier("rolDao")
	RolDao<Rol> rolDao;

	@Override
	public List<Funcion> funcionesByUsuario(Usuario usr) {
		return usr.getRol().getFunciones().stream().collect(Collectors.toList());
	}
	
	@Override
	public List<Modulo> modulosByUsuario(Usuario usr) {
		Usuario usrAux = usuarioDao.findBy("clave",usr.getClave());
		Set<Modulo> mods = new TreeSet<Modulo>();
		for (Funcion fun : usrAux.getRol().getFunciones()) {
			mods.add(fun.getModulo());
		}
		return mods.stream().collect(Collectors.toList());
	}

	@Override
	public Modulo moduloByClave(String clave) {
		return moduloDao.findById(clave);
	}

	@Transactional(readOnly = false)
	public void asignarPrivilegios(String cveRol, List<Funcion> funciones) {
		Rol rol = this.rolDao.findById(cveRol);
		rol.setFunciones(new HashSet<Funcion>(funciones));
		this.rolDao.saveOrUpdate(rol);
	}

	@Override
	public List<Funcion> funcionesByUsuarioByModulo(Usuario us, Modulo mod) {
		return this.funcionDao.funcionesByUsuarioByModulo(us.getRol(),mod);
	}

}
