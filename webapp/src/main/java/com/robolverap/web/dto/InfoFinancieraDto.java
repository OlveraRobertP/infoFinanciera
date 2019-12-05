package com.robolverap.web.dto;

import java.io.Serializable;

import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.InformacionFinanciera;

/**
 * 
 * @author jrobolvp
 *
 */
public class InfoFinancieraDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1713133812120495970L;
	
	private Cuenta cuenta;
	
	private InformacionFinanciera info;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public InformacionFinanciera getInfo() {
		return info;
	}

	public void setInfo(InformacionFinanciera info) {
		this.info = info;
	}
	
	
	

}
