/**
 * 
 */
package com.robolverap.web.vm.security;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.robolverap.bo.ModuloBo;
import com.robolverap.model.app.security.Modulo;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "moduloVM")
public class ModuloVM {
	
	@ManagedProperty("#{moduloBo}")
	private ModuloBo moduloBo;
	
	public void setModuloBo(ModuloBo moduloBo) {
		this.moduloBo = moduloBo;
	}
	
	private List<Modulo> modulos;
	
	public List<Modulo> getModulos() {
		return modulos;
	}
	
	@PostConstruct
	public void init() {
		this.modulos = this.moduloBo.findAll();
	}

}
