/**
 * 
 */
package com.robolverap.impl.bo.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.info.EstadoFinancieroBo;
import com.robolverap.dao.info.CuentaDao;
import com.robolverap.dao.info.EstadoFinancieroDao;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;

/**
 * @author jrobolvp
 *
 */
@Service("edoFinBo")
@Transactional(readOnly = true)
public class EstadoFinancieroBoImpl implements EstadoFinancieroBo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5161431341141309990L;
	
	@Autowired
    @Qualifier("bitacoraDao")
    BitacoraDao<Bitacora> bitacoraDao;
	
	@Autowired
    @Qualifier("edoFinanDao")
	EstadoFinancieroDao<EstadoFinanciero> edoFinanDao;
	
	@Autowired
    @Qualifier("cuentaDao")
	CuentaDao<Cuenta> cuentaDao;

	@Override
	public List<EstadoFinanciero> findAll() {
		return edoFinanDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdateCuenta(Cuenta cuenta, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(cuenta.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		if(cuenta.getId() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_EDO_FIN_CUENTA));
			cuenta.setFecReg(new Date());
			cuenta.setUsuReg(us);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_EDO_FIN_CUENTA));
		}
		cuenta.setFecMod(new Date());
		cuenta.setUsuMod(us);
		this.bitacoraDao.saveOrUpdate(bit);
		cuentaDao.saveOrUpdate(cuenta);
	}

	@Override
	public EstadoFinanciero findEdoFinById(Integer id) {
		return this.edoFinanDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdateEdoFin(EstadoFinanciero entyti, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(entyti.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		if(entyti.getId() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_EDO_FIN));
			entyti.setFecReg(new Date());
			entyti.setUsuReg(us);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_EDO_FIN));
		}
		entyti.setFecMod(new Date());
		entyti.setUsuMod(us);
		this.bitacoraDao.saveOrUpdate(bit);
		edoFinanDao.saveOrUpdate(entyti);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCuenta(Cuenta cuenta, Usuario us) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(cuenta.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(us);
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_EDO_FIN_CUENTA));
		this.bitacoraDao.saveOrUpdate(bit);
		cuentaDao.delete(cuenta);
	}

}
