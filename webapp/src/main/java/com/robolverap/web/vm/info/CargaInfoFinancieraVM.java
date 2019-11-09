package com.robolverap.web.vm.info;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.robolverap.bo.info.CargaInfoFinancieraBo;
import com.robolverap.bo.info.EstadoFinancieroBo;
import com.robolverap.bo.security.BitacoraBo;
import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.services.CalendarService;
import com.robolverap.web.vm.security.SessionVM;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "caragInfVM")
@SessionScoped
public class CargaInfoFinancieraVM {
	@PostConstruct
	public void init() {
		resetValues();
	}
	
	@ManagedProperty("#{sessionVM}")
	private SessionVM sessionBean;

	public void setSessionBean(SessionVM sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	@ManagedProperty("#{calendarService}")
	private CalendarService calendarService;
	
	public void setCalendarService(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	
	public CalendarService getCalendarService() {
		return calendarService;
	}
	
	@ManagedProperty("#{bitacoraBo}")
	private BitacoraBo bitacoraBo;
	
	public void setBitacoraBo(BitacoraBo bitacoraBo) {
		this.bitacoraBo = bitacoraBo;
	}
	
	@ManagedProperty("#{edoFinBo}")
	private EstadoFinancieroBo edoFinBo;
	
	public void setEdoFinBo(EstadoFinancieroBo edoFinBo) {
		this.edoFinBo = edoFinBo;
	}
	
	@ManagedProperty("#{caragInfoFinBo}")
	private CargaInfoFinancieraBo caragInfoFinBo;
	
	
	private EstadoFinanciero selectedEdoFin;
	
	public void setSelectedEdoFin(EstadoFinanciero selectedEdoFin) {
		this.selectedEdoFin = selectedEdoFin;
	}
	
	public EstadoFinanciero getSelectedEdoFin() {
		return selectedEdoFin;
	}
	
	private List<EstadoFinanciero> estadosFinancieros;
	
	public List<EstadoFinanciero> getEstadosFinancieros() {
		return estadosFinancieros;
	}
	
	private Integer monthSelected;
	
	public Integer getMonthSelected() {
		return monthSelected;
	}
	
	public void setMonthSelected(Integer monthSelected) {
		this.monthSelected = monthSelected;
	}
	
	private Integer yearSelected;
	
	public Integer getYearSelected() {
		return yearSelected;
	}
	
	public void setYearSelected(Integer yearSelected) {
		this.yearSelected = yearSelected;
	}
	
	private String fechaSelected;
	
	private List<Cuenta> info;
	
	public List<Cuenta> getInfo() {
		return info;
	}
	
	public String getFechaSelected() {
		return fechaSelected;
	}
	
	public void setFechaSelected(String fechaSelected) {
		this.fechaSelected = fechaSelected;
	}
	
	private void resetValues() {
		fechaSelected= null;
		yearSelected= null;
		monthSelected= null;
		this.estadosFinancieros = this.edoFinBo.findAll();
	}
	
	public void find() {
		this.info = this.caragInfoFinBo.findByEdoFinancieroByFecha(this.selectedEdoFin,this.yearSelected,this.yearSelected);
//		try {
//			info = this.admonReportsBo.extraeBalanceGral(this.yearSelected, this.monthSelected);
//			fechaSelected = DateFormat.formatFull(this.monthSelected,this.yearSelected);
//			this.bitacoraBo.add("DATOS DE LA CONSULTA: "+"MES: "+this.monthSelected+ " , AÑO: "+this.yearSelected,
//					this.sessionBean.getUserInSession(), BitacoraEventClaves.CON_BAL_GRL);
//		}catch(Exception e) {
//			info = null;
//			fechaSelected= null;
//			e.printStackTrace();
//			JsfAppUtils.addResultMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),null);
//		}
		
	}
	
	public String excel() {
		return this.generatePath("xlsx");
	}
	
	public String pdf() {
		return this.generatePath("pdf");
	}
	
	public void consultaPdf() {
//		this.bitacoraBo.add("DATOS DE LA CONSULTA: "+"MES: "+this.monthSelected+ " , AÑO: "+this.yearSelected,
//				this.sessionBean.getUserInSession(), BitacoraEventClaves.CON_PDF_BAL_GRL);
	}
	
	public void consultaExcel() {
//		this.bitacoraBo.add("DATOS DE LA CONSULTA: "+"MES: "+this.monthSelected+ " , AÑO: "+this.yearSelected,
//				this.sessionBean.getUserInSession(), BitacoraEventClaves.CON_XLS_BAL_GRL);
	}

	private String generatePath(String formatFile) {
//		if(this.yearSelected == null || this.monthSelected == null) {
//			return "javascript:void(0)";
//		}else {
//			return  "/run?__report=BalanceGeneral.rptdesign&__format="+formatFile+
//					"&year="+this.yearSelected+
//					"&month="+this.monthSelected+
//					"&fileName=Balance General "+DateFormat.formatFull(this.monthSelected,this.yearSelected);
//		}
		return null;
		
	}
}
