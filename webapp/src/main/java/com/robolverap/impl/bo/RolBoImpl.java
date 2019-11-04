/**
 * 
 */
package com.robolverap.impl.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.RolBo;
import com.robolverap.dao.BitacoraDao;
import com.robolverap.dao.RolDao;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Rol;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author Roberto Olvera
 *
 */
@Service("rolBo")
@Transactional(readOnly = true)
public class RolBoImpl implements RolBo,Serializable {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8917149745218953568L;
	@Autowired
    @Qualifier("rolDao")
    RolDao<Rol> rolDao;
    
	@Autowired
    @Qualifier("bitacoraDao")
	BitacoraDao<Bitacora> bitacoraDao;
  
	@Override
	public Rol findByClave(String clave) {
		return rolDao.findBy("clave", clave);
	}

	@Override
	public List<Rol> findAll() {
		return rolDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = false)
	public void delete(Rol rol,Usuario reg) {
		Bitacora bit = new Bitacora();
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_USR));
		bit.setDescripcion(rol.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(reg);
		this.bitacoraDao.saveOrUpdate(bit);
		rolDao.delete(rol);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(Rol rol,Usuario reg) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(rol.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(reg);
		if(rol.getUsuReg() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_USR));
			rol.setFecReg(new Date());
			rol.setUsuReg(reg);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_USR));
		}
		rol.setFecMod(new Date());
		rol.setUsuMod(reg);
		this.bitacoraDao.saveOrUpdate(bit);
		rolDao.saveOrUpdate(rol);
	}

}
