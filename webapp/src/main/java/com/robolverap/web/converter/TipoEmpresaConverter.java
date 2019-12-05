/**
 * 
 */
package com.robolverap.web.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.robolverap.bo.admon.TipoEmpresaBo;
import com.robolverap.model.app.financieros.EstadoFinanciero;


/**
 * 
 * Converter para la EstadoFinanciero 
 * @author jrobolvp
 *
 */
@ManagedBean(name = "tipoEmpresaConverter")
public class TipoEmpresaConverter implements Converter {

	@ManagedProperty("#{tipoEmpresaBo}")
	private TipoEmpresaBo tipoEmpresaBo;
	
	public void setTipoEmpresaBo(TipoEmpresaBo tipoEmpresaBo) {
		this.tipoEmpresaBo = tipoEmpresaBo;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null){
			return null;
		}
		return tipoEmpresaBo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		return (((EstadoFinanciero)value).getId()).toString();
	}

}

