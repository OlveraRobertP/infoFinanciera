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

import com.robolverap.bo.security.ParametroBo;
import com.robolverap.model.app.security.Parametro;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "parametroVM")
@SessionScoped
public class ParametroVM {
	
	@ManagedProperty("#{parametroBo}")
	private ParametroBo parametroBo;
	
	public void setParametroBo(ParametroBo parametroBo) {
		this.parametroBo = parametroBo;
	}
	
	private List<Parametro> parametroes;
	
	public List<Parametro> getParametroes() {
		return parametroes;
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
	
	private Parametro entytiEdit;

	public Parametro getEntytiEdit() {
		return entytiEdit;
	}

	public void setEntytiEdit(Parametro entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("parametro.save.sucess.detail")+this.entytiEdit.getClave();
				
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.parametroBo.saveOrUpdate(this.entytiEdit,us);
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
		PrimeFaces.current().dialog().closeDynamic("parametrosMtto");
	}

	public void editar(Parametro entity) {
		this.entytiEdit = entity;
		openDialogMtto();
	}

	public void eliminar(Parametro entity) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("parametro.delete.sucess.detail")+entity.getClave();
				
		try {
			this.parametroBo.delete(entity,this.sessionBean.getUserInSession());
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
		this.parametroes = this.parametroBo.findAll();
	}

	public void add() {
		this.entytiEdit = new Parametro();
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
		PrimeFaces.current().dialog().openDynamic("parametrosMtto", options, null);
	}

}
