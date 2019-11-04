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

import com.robolverap.bo.ParametroBo;
import com.robolverap.dao.BitacoraDao;
import com.robolverap.dao.ParametroDao;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Parametro;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author Roberto Olvera
 *
 */
@Service("parametroBo")
@Transactional(readOnly = true)
public class ParametroBoImpl implements ParametroBo,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6800618917841945573L;

	/**
	 * 
	 */
	
	@Autowired
    @Qualifier("parametroDao")
    ParametroDao<Parametro> parametroDao;
    
	@Autowired
    @Qualifier("bitacoraDao")
	BitacoraDao<Bitacora> bitacoraDao;
  
	@Override
	public Parametro findByClave(String clave) {
		return parametroDao.findBy("clave", clave);
	}

	@Override
	public List<Parametro> findAll() {
		return parametroDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = false)
	public void delete(Parametro parametro,Usuario reg) {
		Bitacora bit = new Bitacora();
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_PARAM));
		bit.setDescripcion(parametro.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(reg);
		this.bitacoraDao.saveOrUpdate(bit);
		parametroDao.delete(parametro);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(Parametro parametro,Usuario reg) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(parametro.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(reg);
		if(parametro.getUsuReg() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_PARAM));
			parametro.setFecReg(new Date());
			parametro.setUsuReg(reg);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_PARAM));
		}
		parametro.setFecMod(new Date());
		parametro.setUsuMod(reg);
		this.bitacoraDao.saveOrUpdate(bit);
		parametroDao.saveOrUpdate(parametro);
	}

	@Override
	public Parametro findById(Integer id) {
		return parametroDao.findBy("id", id);
	}

}
