/**
 * 
 */
package com.robolverap.web.vm.security;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.robolverap.bo.security.BitacoraBo;
import com.robolverap.model.app.security.Bitacora;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "bitacoraVM")
public class BitacoraVM {
	
	@ManagedProperty("#{bitacoraBo}")
	private BitacoraBo bitacoraBo;
	
	public void setBitacoraBo(BitacoraBo bitacoraBo) {
		this.bitacoraBo = bitacoraBo;
	}
	
	private List<Bitacora> bitacoraes;
	
	public List<Bitacora> getBitacoraes() {
		return bitacoraes;
	}
	
	@PostConstruct
	public void init() {
		this.bitacoraes = this.bitacoraBo.findAll();
	}

}
