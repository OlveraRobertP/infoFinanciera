/**
 * 
 */
package com.robolverap.web.vm.security;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.robolverap.bo.LoginBo;
import com.robolverap.bo.SecurityBo;
import com.robolverap.bo.UsuarioBo;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;
import com.robolverap.web.jsf.JsfAppUtils;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "resetPassVM")
public class ResetPassVM {

	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo usuarioBo;
	
	@ManagedProperty("#{loginBo}")
	private LoginBo loginBo;
	
	@ManagedProperty("#{securityBo}")
	private SecurityBo securityBo;
	

	@ManagedProperty("#{sessionVM}")
	private SessionVM sessionBean;

	private Usuario usuario;
	
	private String password;
	
	private String passwordConfirm;
	
	@ManagedProperty("#{msg}")
	private ResourceBundle msgBundle;

	private String user;

	private String token;
	
	public void setMsgBundle(ResourceBundle msgBundle) {
		this.msgBundle = msgBundle;
	}
	
	@PostConstruct
	public void init()  {
		this.usuario = this.sessionBean.getUserInSession();
		
		FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        if(fc!= null && fc.getPartialViewContext() != null && !fc.getPartialViewContext().isAjaxRequest()) {
        	user = params.get("user");
        	token = params.get("token");
        	this.usuario = this.usuarioBo.findByClave(user);
        }
        
		if(this.usuario == null || !this.usuario.getResetToken().equals(token)) {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect(context.getRequestContextPath() + "/login/unautorized"+SystemValues.DEFAULT_SUFIX);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setSessionBean(SessionVM sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	public UsuarioBo getUsuarioBo() {
		return usuarioBo;
	}

	public void setUsuarioBo(UsuarioBo usuarioBo) {
		this.usuarioBo = usuarioBo;
	}

	public LoginBo getLoginBo() {
		return loginBo;
	}

	public void setLoginBo(LoginBo loginBo) {
		this.loginBo = loginBo;
	}

	public SecurityBo getSecurityBo() {
		return securityBo;
	}

	public void setSecurityBo(SecurityBo securityBo) {
		this.securityBo = securityBo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	public void changePass() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("reset.password.save.sucess.detail");
		
		if(this.password.equals(this.passwordConfirm)) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("reset.password.error");
			messageDetail = msgBundle.getString("reset.password.error.no.match");
		}else {
			try {
				this.usuario.setContraseña(this.securityBo.encodePassword(this.password));
				this.usuario.setResetPassword(false);
				this.usuarioBo.saveOrUpdate(this.usuario,this.usuario);
			}
			catch (Exception e) {
				severity = FacesMessage.SEVERITY_ERROR;
				messageTitle =  msgBundle.getString("global.error");
				messageDetail = e.getMessage();
				e.printStackTrace();
			}
		}
				
		
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
	}
	
}
