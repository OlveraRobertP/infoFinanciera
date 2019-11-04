/**
 * 
 */
package com.robolverap.web.vm.security;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "sessionVM")
@SessionScoped
public class SessionVM {
	
	
	@PostConstruct
	public void init() {
	
	}
	
	public Usuario getUserInSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Usuario) session.getAttribute(SystemValues.USER_IN_SESSION.toString());
	}

}
