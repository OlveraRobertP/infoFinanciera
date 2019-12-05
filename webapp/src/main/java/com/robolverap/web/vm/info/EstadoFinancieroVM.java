/**
 * 
 */
package com.robolverap.web.vm.info;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.robolverap.bo.admon.TipoEmpresaBo;
import com.robolverap.bo.info.EstadoFinancieroBo;
import com.robolverap.model.app.admon.TipoEmpresa;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.jsf.JsfAppUtils;
import com.robolverap.web.vm.security.SessionVM;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "edoFinVM")
@SessionScoped
public class EstadoFinancieroVM {
	
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
	
	@ManagedProperty("#{edoFinBo}")
	private EstadoFinancieroBo edoFinBo;
	
	private List<EstadoFinanciero> estadosFinancieros;

	private EstadoFinanciero entytiEdit;
	
	public EstadoFinanciero getEntytiEdit() {
		return entytiEdit;
	}
	
	public void setEntytiEdit(EstadoFinanciero entytiEdit) {
		this.entytiEdit = entytiEdit;
	}
	
	private Cuenta cuentaEdit;
	
	public Cuenta getCuentaEdit() {
		return cuentaEdit;
	}
	
	public void setCuentaEdit(Cuenta cuentaEdit) {
		this.cuentaEdit = cuentaEdit;
	}
	
	public List<EstadoFinanciero> getEstadosFinancieros() {
		return estadosFinancieros;
	}

	public void setEdoFinBo(EstadoFinancieroBo edoFinBo) {
		this.edoFinBo = edoFinBo;
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
		this.estadosFinancieros = this.edoFinBo.findAll();
		this.tiposEmpresas = this.tipoEmpresaBo.findAll();
	}
	
	public void editar(EstadoFinanciero edo) {
		this.entytiEdit = edo;
		this.cuentaEdit = new Cuenta();
	}
	
	public void add() {
		this.entytiEdit = new EstadoFinanciero();
		this.cuentaEdit = new Cuenta();
	}
	
	public void saveCuenta() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.cuenta.save.sucess.detail")+this.entytiEdit.getClave();
		
		try {
			this.cuentaEdit.setEdoFinanciero(this.entytiEdit);
			
			Usuario us = this.sessionBean.getUserInSession();
			this.edoFinBo.saveOrUpdateCuenta(this.cuentaEdit,us);
			this.estadosFinancieros = this.edoFinBo.findAll();
			this.entytiEdit = this.edoFinBo.findEdoFinById(this.entytiEdit.getId());
			this.estadosFinancieros = this.edoFinBo.findAll();

		}
		catch (Exception e) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("global.error");
			messageDetail = e.getMessage();
			e.printStackTrace();
		}
		
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
		
	}
	
	public void saveOrUpdate() {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.save.sucess.detail")+this.entytiEdit.getClave();
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.edoFinBo.saveOrUpdateEdoFin(this.entytiEdit,us);
			this.estadosFinancieros = this.edoFinBo.findAll();
			//resetValues();
		}
		catch (Exception e) {
			severity = FacesMessage.SEVERITY_ERROR;
			messageTitle =  msgBundle.getString("global.error");
			messageDetail = e.getMessage();
			e.printStackTrace();
		}
		JsfAppUtils.addResultMessage(severity,messageTitle,messageDetail);
	}
	
	public void editarCuenta(Cuenta cta) {
		this.cuentaEdit = cta;
	}
	
	public void eliminarCuenta(Cuenta cta) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		String messageTitle =  msgBundle.getString("global.save.sucess");
		String messageDetail = msgBundle.getString("edofin.cuenta.delete.sucess.detail");
		
		try {
			Usuario us = this.sessionBean.getUserInSession();
			this.edoFinBo.deleteCuenta(this.cuentaEdit,us);
			this.estadosFinancieros = this.edoFinBo.findAll();
			this.entytiEdit = this.edoFinBo.findEdoFinById(this.entytiEdit.getId());
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
