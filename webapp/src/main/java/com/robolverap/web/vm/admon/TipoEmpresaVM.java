/**
 * 
 */
package com.robolverap.web.vm.admon;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.robolverap.bo.admon.TipoEmpresaBo;
import com.robolverap.model.app.admon.TipoEmpresa;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;
import com.robolverap.web.vm.security.SessionVM;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "tipoEmpresaVM")
@SessionScoped
public class TipoEmpresaVM {

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

	@ManagedProperty("#{tipoEmpresaBo}")
	private TipoEmpresaBo tipoEmpresaBo;

	public void setTipoEmpresaBo(TipoEmpresaBo tipoEmpresaBo) {
		this.tipoEmpresaBo = tipoEmpresaBo;
	}

	private List<TipoEmpresa> tiposEmpresas;

	public List<TipoEmpresa> getTiposEmpresas() {
		return tiposEmpresas;
	}

	@PostConstruct
	public void init() {
		resetValues();
	}

	private void resetValues() {
		this.tiposEmpresas = this.tipoEmpresaBo.findAll();
	}
	
	private TipoEmpresa entytiEdit;
	
	public TipoEmpresa getEntytiEdit() {
		return entytiEdit;
	}
	
	public void setEntytiEdit(TipoEmpresa entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	public void editar(TipoEmpresa tiE) {
		this.entytiEdit = tiE;
	}
	
	public void add() {
		this.entytiEdit = new TipoEmpresa();
	}
	
	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.save.sucess.detail")+" "+this.entytiEdit.getClave();
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.tipoEmpresaBo.saveOrUpdate(this.entytiEdit,us);
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
	
	
	public void eliminar(TipoEmpresa tipEmp) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.cuenta.delete.sucess.detail");
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.tipoEmpresaBo.delete(this.entytiEdit,us);
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

}
