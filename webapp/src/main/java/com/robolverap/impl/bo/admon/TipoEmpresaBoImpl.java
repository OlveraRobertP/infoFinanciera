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

import com.robolverap.bo.admon.TipoEmpresaBo;
import com.robolverap.dao.admon.TipoEmpresaDao;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.model.app.admon.TipoEmpresa;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author jrobolvp
 *
 */
@Service("tipoEmpresaBo")
@Transactional(readOnly = true)
public class TipoEmpresaBoImpl implements Serializable,TipoEmpresaBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 883548454012365431L;
	
	@Autowired
    @Qualifier("bitacoraDao")
    BitacoraDao<Bitacora> bitacoraDao;
	
	
	@Autowired
    @Qualifier("tipoEmpresaDao")
	TipoEmpresaDao<TipoEmpresa> tipoEmpresaDao;


	@Override
	public TipoEmpresa findById(Integer id) {
		return tipoEmpresaDao.findById(id);
	}


	@Override
	public List<TipoEmpresa> findAll() {
		return tipoEmpresaDao.findAll();
	}


	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(TipoEmpresa entyti, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(entyti.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		if(entyti.getId() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_TIPO_EMP));
			entyti.setFecReg(new Date());
			entyti.setUsuReg(us);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_TIPO_EMP));
		}
		entyti.setFecMod(new Date());
		entyti.setUsuMod(us);
		this.bitacoraDao.saveOrUpdate(bit);
		tipoEmpresaDao.saveOrUpdate(entyti);
	}


	@Override
	@Transactional(readOnly = false)
	public void delete(TipoEmpresa entyti, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(entyti.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_TIPO_EMP));
		this.bitacoraDao.saveOrUpdate(bit);
		tipoEmpresaDao.delete(entyti);
	}
	
	
}
