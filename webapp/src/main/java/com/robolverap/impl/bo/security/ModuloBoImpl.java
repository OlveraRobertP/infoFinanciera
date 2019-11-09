/**
 * 
 */
package com.robolverap.impl.bo.security;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.security.ModuloBo;
import com.robolverap.dao.security.ModuloDao;
import com.robolverap.model.app.security.Modulo;

/**
 * @author Roberto Olvera
 *
 */
@Service("moduloBo")
@Transactional(readOnly = true)
public class ModuloBoImpl implements ModuloBo,Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5503153816630432612L;
	
	@Autowired
    @Qualifier("moduloDao")
	ModuloDao<Modulo> moduloDao;
    
  
	@Override
	public Modulo findByClave(String clave) {
		return moduloDao.findBy("clave", clave);
	}

	@Override
	public List<Modulo> findAll() {
		return moduloDao.findAll();
	}

}
