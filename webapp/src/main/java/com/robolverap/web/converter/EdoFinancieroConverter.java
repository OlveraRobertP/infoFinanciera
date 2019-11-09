/**
 * 
 */
package com.robolverap.web.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.robolverap.bo.info.EstadoFinancieroBo;
import com.robolverap.model.app.financieros.EstadoFinanciero;

/**
 * 
 * Converter para la clase ROL
 * @author jrobolvp
 *
 */
@ManagedBean(name = "edoFinConverter")
public class EdoFinancieroConverter implements Converter {

	@ManagedProperty("#{edoFinBo}")
	private EstadoFinancieroBo edoFinBo;
	
	public void setEdoFinBo(EstadoFinancieroBo edoFinBo) {
		this.edoFinBo = edoFinBo;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null){
			return null;
		}
		return edoFinBo.findEdoFinById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		return (((EstadoFinanciero)value).getId()).toString();
	}

}