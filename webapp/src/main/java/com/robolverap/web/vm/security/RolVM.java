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

import com.robolverap.bo.security.RolBo;
import com.robolverap.model.app.security.Rol;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "rolVM")
@SessionScoped
public class RolVM {
	
	@ManagedProperty("#{rolBo}")
	private RolBo rolBo;
	
	public void setRolBo(RolBo rolBo) {
		this.rolBo = rolBo;
	}
	
	private List<Rol> roles;
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	@PostConstruct
	public void init() {
		resetValues();
	}
	
	@ManagedProperty("#{sessionVM}")
	private SessionVM sessionBean;

	public void setSessionBean(SessionVM sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	@ManagedProperty("#{msg}")
	private ResourceBundle msgBundle;
	
	public void setMsgBundle(ResourceBundle msgBundle) {
		this.msgBundle = msgBundle;
	}
	
	private Rol entytiEdit;

	public Rol getEntytiEdit() {
		return entytiEdit;
	}

	public void setEntytiEdit(Rol entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("rol.save.sucess.detail")+this.entytiEdit.getClave();
				
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.rolBo.saveOrUpdate(this.entytiEdit,us);
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

	public void closeDialog() {
		PrimeFaces.current().dialog().closeDynamic("rolesMtto");
	}

	public void editar(Rol entity) {
		this.entytiEdit = entity;
		openDialogMtto();
	}

	public void eliminar(Rol entity) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("rol.delete.sucess.detail")+entity.getClave();
				
		try {
			this.rolBo.delete(entity,this.sessionBean.getUserInSession());
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
		this.roles = this.rolBo.findAll();
	}

	public void add() {
		this.entytiEdit = new Rol();
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
		PrimeFaces.current().dialog().openDynamic("rolesMtto", options, null);
	}

}
