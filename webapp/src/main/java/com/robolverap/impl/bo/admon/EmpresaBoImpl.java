/**
 * 
 */
package com.robolverap.impl.bo.admon;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.admon.EmpresaBo;
import com.robolverap.dao.admon.EmpresaDao;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.model.app.admon.Empresa;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author jrobolvp
 *
 */
@Service("empresaBo")
@Transactional(readOnly = true)
public class EmpresaBoImpl implements Serializable,EmpresaBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7789615862752953254L;
	
	@Autowired
    @Qualifier("bitacoraDao")
    BitacoraDao<Bitacora> bitacoraDao;
	
	
	@Autowired
    @Qualifier("empresaDao")
	EmpresaDao<Empresa> empresaDao;

	@Override
	public List<Empresa> findAll() {
		return empresaDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(Empresa entyti, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(entyti.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		if(entyti.getId() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_EMP));
			entyti.setFecReg(new Date());
			entyti.setUsuReg(us);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_EMP));
		}
		entyti.setFecMod(new Date());
		entyti.setUsuMod(us);
		this.bitacoraDao.saveOrUpdate(bit);
		empresaDao.saveOrUpdate(entyti);
	}


	@Override
	@Transactional(readOnly = false)
	public void delete(Empresa entyti, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(entyti.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_EMP));
		this.bitacoraDao.saveOrUpdate(bit);
		empresaDao.delete(entyti);
	}

}
