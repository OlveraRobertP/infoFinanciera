package com.robolverap.web.vm.security;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.robolverap.bo.security.BitacoraBo;
import com.robolverap.bo.security.LoginBo;
import com.robolverap.bo.security.PermisoBo;
import com.robolverap.bo.security.SecurityBo;
import com.robolverap.bo.security.UsuarioBo;
import com.robolverap.exceptions.SecurityException;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;
import com.robolverap.web.constants.BitacoraEventClaves;
import com.robolverap.web.jsf.JsfAppUtils;

@ManagedBean(name = "loginVM")
@RequestScoped
public class LoginVM {

	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo usuarioBo;
	
	@ManagedProperty("#{bitacoraBo}")
	private BitacoraBo bitacoraBo;
	
	@ManagedProperty("#{loginBo}")
	private LoginBo loginBo;
	
	@ManagedProperty("#{securityBo}")
	private SecurityBo securityBo;
	
	@ManagedProperty("#{permisoBo}")
	private PermisoBo permisoBo;
		
	@ManagedProperty("#{msg}")
	private ResourceBundle msgBundle;
	
	private String username;
    
    private String password;

    @PostConstruct
	public void init()  {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session != null && session.getAttribute(SystemValues.USER_IN_SESSION.toString()) != null) {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			try {
				context.redirect(context.getRequestContextPath() + "/login/inicio"+SystemValues.DEFAULT_SUFIX);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void login() {
		if(this.username != null && this.password != null) {
			Usuario user = usuarioBo.findByClave(this.username);
			if(user==null ) {
				JsfAppUtils.addResultMessage(FacesMessage.SEVERITY_ERROR, msgBundle.getString("login.nouser"),msgBundle.getString("login.nouser.detail"));
				return;
			}
			
			if( !user.getActivo()) {
				JsfAppUtils.addResultMessage(FacesMessage.SEVERITY_ERROR, msgBundle.getString("login.user.inactivo"),msgBundle.getString("login.user.inactivo.detail"));
				return;
			}
			try {
				if(!this.securityBo.validateLogin(this.username, this.password)) {
					JsfAppUtils.addResultMessage(FacesMessage.SEVERITY_ERROR, msgBundle.getString("login.nopassword"),msgBundle.getString("login.nopassword.detail"));
					return;
				}
			} catch (SecurityException e1) {
				e1.printStackTrace();
			}
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute(SystemValues.USER_IN_SESSION.toString(), user);
			this.loginBo.setUltimoAcceso(user);
			this.bitacoraBo.add(user,BitacoraEventClaves.LOGIN_SYS);
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect(context.getRequestContextPath() + "/login/inicio"+SystemValues.DEFAULT_SUFIX);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.bitacoraBo.add((Usuario)session.getAttribute(SystemValues.USER_IN_SESSION.toString()),BitacoraEventClaves.LOGOUT_SYS);
		session.removeAttribute(SystemValues.USER_IN_SESSION.toString());
		
	}

	public void setUsuarioBo(UsuarioBo usuarioBo) {
		this.usuarioBo = usuarioBo;
	}
	
	public void setSecurityBo(SecurityBo securityBo) {
		this.securityBo = securityBo;
	}
	
	public void setPermisoBo(PermisoBo permisoBo) {
		this.permisoBo = permisoBo;
	}
	
	public void setLoginBo(LoginBo loginBo) {
		this.loginBo = loginBo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setMsgBundle(ResourceBundle msgBundle) {
		this.msgBundle = msgBundle;
	}
	public void setBitacoraBo(BitacoraBo bitacoraBo) {
		this.bitacoraBo = bitacoraBo;
	}
}
