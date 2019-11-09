/**
 * 
 */
package com.robolverap.web.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.robolverap.bo.security.RolBo;
import com.robolverap.model.app.security.Rol;

/**
 * 
 * Converter para la clase ROL
 * @author jrobolvp
 *
 */
@ManagedBean(name = "rolConverter")
public class RolConverter implements Converter {

	@ManagedProperty("#{rolBo}")
	private RolBo rolBo;
	
	public void setRolBo(RolBo rolBo) {
		this.rolBo = rolBo;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null){
			return null;
		}
		return rolBo.findByClave(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		return ((Rol)value).getClave();
	}

}