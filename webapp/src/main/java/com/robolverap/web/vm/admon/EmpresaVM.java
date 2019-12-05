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

import com.robolverap.bo.admon.EmpresaBo;
import com.robolverap.model.app.admon.Empresa;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;
import com.robolverap.web.vm.security.SessionVM;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "empresaVM")
@SessionScoped
public class EmpresaVM {

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

	@ManagedProperty("#{empresaBo}")
	private EmpresaBo empresaBo;

	public void setEmpresaBo(EmpresaBo EmpresaBo) {
		this.empresaBo = EmpresaBo;
	}

	private List<Empresa> tiposEmpresas;

	public List<Empresa> getTiposEmpresas() {
		return tiposEmpresas;
	}

	@PostConstruct
	public void init() {
		resetValues();
	}

	private void resetValues() {
		this.tiposEmpresas = this.empresaBo.findAll();
	}
	
	private Empresa entytiEdit;
	
	public Empresa getEntytiEdit() {
		return entytiEdit;
	}
	
	public void setEntytiEdit(Empresa entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	public void editar(Empresa tiE) {
		this.entytiEdit = tiE;
	}
	
	public void add() {
		this.entytiEdit = new Empresa();
	}
	
	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.save.sucess.detail")+" "+this.entytiEdit.getNombre();
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.empresaBo.saveOrUpdate(this.entytiEdit,us);
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
	
	
	public void eliminar(Empresa tipEmp) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.cuenta.delete.sucess.detail");
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.empresaBo.delete(this.entytiEdit,us);
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
