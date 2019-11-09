/**
 * 
 */
package com.robolverap.web.vm.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.robolverap.bo.security.UsuarioBo;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "usuarioVM")
@SessionScoped
public class UsuarioVM {

	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo usuarioBo;

	public void setUsuarioBo(UsuarioBo usuarioBo) {
		this.usuarioBo = usuarioBo;
	}
	
	@ManagedProperty("#{sessionVM}")
	private SessionVM sessionBean;

	public void setSessionBean(SessionVM sessionBean) {
		this.sessionBean = sessionBean;
	}

	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	private Usuario entytiEdit;

	public Usuario getEntytiEdit() {
		return entytiEdit;
	}

	public void setEntytiEdit(Usuario entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	@ManagedProperty("#{msg}")
	private ResourceBundle msgBundle;
	
	public void setMsgBundle(ResourceBundle msgBundle) {
		this.msgBundle = msgBundle;
	}

	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("user.save.sucess.detail")+this.entytiEdit.getClave();
				
		try {
			Usuario us = this.sessionBean.getUserInSession();
			boolean nvoUsuario = false;
			if(this.entytiEdit.getClave() == null || this.entytiEdit.getClave().trim().length() <= 0) {
				nvoUsuario = true;
			}
			
			this.usuarioBo.saveOrUpdate(this.entytiEdit,us);
			resetValues();
			
			if(nvoUsuario) {
				this.usuarioBo.resetPassword(us,this.sessionBean.getUserInSession());
			}
		}
		catch (Exception e) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("global.error");
			messageDetail = e.getMessage();
			e.printStackTrace();
		}
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
	}

	public void closeDialog() {
		PrimeFaces.current().dialog().closeDynamic("usuariosMtto");
	}

	public void editar(Usuario usu) {
		this.entytiEdit = usu;
		openDialogMtto();
	}
	
	public void resetPassword(Usuario usu) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("user.reset.pass.sucess.detail")+usu.getClave();
				
		try {
			this.usuarioBo.resetPassword(usu,this.sessionBean.getUserInSession());
			resetValues();
		}
		catch (Exception e) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("global.error");
			messageDetail = e.getMessage();
			e.printStackTrace();
		}
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
	}

	
	

	public void eliminar(Usuario usu) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("user.delete.sucess.detail")+usu.getClave();
				
		try {
			this.usuarioBo.delete(usu,this.sessionBean.getUserInSession());
			resetValues();
		}
		catch (Exception e) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("global.error");
			messageDetail = e.getMessage();
			e.printStackTrace();
		}
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
	}

	private void resetValues() {
		this.usuarios = this.usuarioBo.findAll();
	}

	public void add() {
		this.entytiEdit = new Usuario();
		openDialogMtto();
	}

	public void onAdd(SelectEvent event) {
		if (event.getObject() instanceof Object[]) {
			Object[] msg = (Object[]) event.getObject();
			Severity severity = (Severity) msg[0];
			String messageTitle = (String) msg[1];
			String messageBody = (String) msg[2];
			FacesMessage message = new FacesMessage(severity, messageTitle, messageBody);
			FacesContext.getCurrentInstance().addMessage(null, message);
			resetValues();
		}
	}

	private void openDialogMtto() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("draggable", true);
		options.put("closable", false);
		options.put("modal", true);
		options.put("weight", 1800);
		options.put("height", 350);
		options.put("contentWeight", 1800);
		options.put("contentHeight", 350);
		PrimeFaces.current().dialog().openDynamic("usuariosMtto", options, null);
	}

	@PostConstruct
	public void init() {
		resetValues();
	}

}
