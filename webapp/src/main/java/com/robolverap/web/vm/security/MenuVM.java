package com.robolverap.web.vm.security;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.robolverap.bo.PermisoBo;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;

@ManagedBean(name = "menuVM")
public class MenuVM {
	private MenuModel model;

	@ManagedProperty("#{permisoBo}")
	private PermisoBo permisoBo;
	
	@ManagedProperty("#{lbl}")
	private ResourceBundle lblBundle;

	@PostConstruct
	public void init() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Usuario us = (Usuario) session.getAttribute(
				SystemValues.USER_IN_SESSION.toString());
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = context.getRequestContextPath();
		
		if(us != null) {
			model = new DefaultMenuModel();
			
			Modulo inicio = this.permisoBo.moduloByClave("INI");
			
			List<Modulo> modulos = permisoBo.modulosByUsuario(us);
			
			DefaultMenuItem inicioMenu = new DefaultMenuItem(lblBundle.getString(inicio.getEtiqueta()));
			inicioMenu.setIcon(lblBundle.getString(inicio.getIcono()));
			inicioMenu.setUrl("/login/inicio"+SystemValues.DEFAULT_SUFIX);
			
			model.addElement(inicioMenu);
			
			for (Modulo mod : modulos) {
				DefaultSubMenu auxMenu = new DefaultSubMenu(lblBundle.getString(mod.getEtiqueta()));
				auxMenu.setIcon(lblBundle.getString(mod.getIcono()));
				
				List<Funcion> funciones = this.permisoBo.funcionesByUsuarioByModulo(us,mod);
				for(Funcion f : funciones) {
					DefaultMenuItem auxFunc = new DefaultMenuItem(lblBundle.getString(f.getEtiqueta()));
					auxFunc.setIcon(lblBundle.getString(f.getIcono()));
					auxFunc.setUrl(f.getUrl()+SystemValues.DEFAULT_SUFIX);
					auxMenu.addElement(auxFunc);
				}
				model.addElement(auxMenu);
			}
		}
	
	}

	public MenuModel getModel() {
		return model;
	}
	
	public void setLblBundle(ResourceBundle lblBundle) {
		this.lblBundle = lblBundle;
	}

	public void setPermisoBo(PermisoBo permisoBo) {
		this.permisoBo = permisoBo;
	}

	public boolean canViewMenu() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(SystemValues.USER_IN_SESSION.toString()) != null;
	}
}
