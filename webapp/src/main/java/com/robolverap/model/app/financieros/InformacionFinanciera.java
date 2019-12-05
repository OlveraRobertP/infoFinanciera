/**
 * 
 */
package com.robolverap.model.app.financieros;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.robolverap.model.app.admon.Empresa;
import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
@Entity
@Table(name = "fin_info_fin")
public class InformacionFinanciera implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4357456473086765857L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "MONTO", nullable = true)
	private BigDecimal monto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CUENTA")
	private Cuenta cuenta;
	
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@Column(name = "F_ALTA", nullable = false)
	private Date fecReg;

	@Column(name = "F_MODIF", nullable = false)
	private Date fecMod;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO_ALTA")
	private Usuario usuReg;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO_MODIF")
	private Usuario usuMod;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPRESA")
	private Empresa empresa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public Usuario getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(Usuario usuReg) {
		this.usuReg = usuReg;
	}

	public Usuario getUsuMod() {
		return usuMod;
	}

	public void setUsuMod(Usuario usuMod) {
		this.usuMod = usuMod;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "InformacionFinanciera [id=" + id + ", monto=" + monto + ", cuenta=" + cuenta + ", fecha=" + fecha
				+ ", empresa=" + empresa + "]";
	}

	


}
