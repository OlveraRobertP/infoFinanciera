/**
 * 
 */
package com.robolverap.impl.bo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.FuncionBo;
import com.robolverap.dao.FuncionDao;
import com.robolverap.dao.RolDao;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Rol;

/**
 * @author Roberto Olvera
 *
 */
@Service("funcionBo")
@Transactional(readOnly = true)
public class FuncionBoImpl implements FuncionBo,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -550337378731686682L;
	@Autowired
    @Qualifier("funcionDao")
	FuncionDao<Funcion> funcionDao;
	
	@Autowired
    @Qualifier("rolDao")
    RolDao<Rol> rolDao;
    
    
  
	@Override
	public Funcion findByClave(String clave) {
		return funcionDao.findBy("clave", clave);
	}

	@Override
	public List<Funcion> findAll() {
		return funcionDao.findAll();
	}

	@Override
	public List<Funcion> findByCveRol(String rolSelected) {
		Rol rolSel = rolDao.findById(rolSelected);
		return rolSel.getFunciones().stream().collect(Collectors.toList());
		//return funcionDao.findByCveRol(rolSelected);
	}

}
