/**
 * 
 */
package com.robolverap.impl.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.info.CargaInfoFinancieraBo;
import com.robolverap.dao.info.CuentaDao;
import com.robolverap.dao.info.EstadoFinancieroDao;
import com.robolverap.dao.info.InformacionFinancieraDao;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.financieros.InformacionFinanciera;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.DateUtil;
import com.robolverap.web.constants.BitacoraEventClaves;
import com.robolverap.web.dto.InfoFinancieraDto;

/**
 * @author jrobolvp
 *
 */
@Service("caragInfoFinBo")
@Transactional(readOnly = true)
public class CargaInfoFinancieraBoImpl implements CargaInfoFinancieraBo, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1700313540121525705L;

	@Autowired
    @Qualifier("bitacoraDao")
    BitacoraDao<Bitacora> bitacoraDao;
	
	@Autowired
    @Qualifier("edoFinanDao")
	EstadoFinancieroDao<EstadoFinanciero> edoFinanDao;
	
	@Autowired
    @Qualifier("cuentaDao")
	CuentaDao<Cuenta> cuentaDao;
	
	@Autowired
    @Qualifier("infoFinanDao")
	InformacionFinancieraDao<InformacionFinanciera> infoFinanDao;

	

	@Override
	public List<InfoFinancieraDto> findByEdoFinancieroByFecha(EstadoFinanciero edoFinanciero, Integer year,
			Integer month) {
		List<Cuenta>cuentas = cuentaDao.findByEdoFinanciero(edoFinanciero);
		List<InfoFinancieraDto> info = new ArrayList<InfoFinancieraDto>();
		for (Cuenta cuenta : cuentas) {
			InfoFinancieraDto e = new InfoFinancieraDto();
			e.setCuenta(cuenta);
			InformacionFinanciera inf = infoFinanDao.findByCtaByPeriodo(cuenta,DateUtil.ultimoDiaMes(year, month));
			if(inf==null) {
				inf = new InformacionFinanciera();
			}
			e.setInfo(inf);
			info.add(e);
		}
		return info;
	}



	@Override
	@Transactional(readOnly = false)
	public void saveInfo(List<InfoFinancieraDto> info, Usuario us, Integer year, Integer month) {
		
		for (InfoFinancieraDto in : info) {
			InformacionFinanciera entyti = in.getInfo();
			entyti.setCuenta(in.getCuenta());
			entyti.setFecha(DateUtil.ultimoDiaMes(year, month).getTime());
			
			Bitacora bit = new Bitacora();
			bit.setDescripcion(entyti.toString());
			bit.setFecReg(new Date());
			bit.setUsuReg(us);
			if(entyti.getId() == null) {
				bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_INFO_FIN));
				entyti.setFecReg(new Date());
				entyti.setUsuReg(us);
			}else {
				bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_INFO_FIN));
			}
			entyti.setFecMod(new Date());
			entyti.setUsuMod(us);
			this.bitacoraDao.saveOrUpdate(bit);
			infoFinanDao.saveOrUpdate(entyti);
		}
		
		
	}

}
