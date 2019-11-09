/**
 * 
 */
package com.robolverap.model.app.financieros;

import java.io.Serializable;
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

import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
@Entity
@Table(name = "fin_cuenta")
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3332782775968584377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column (name = "CLAVE", unique = true, nullable = false, length = 15)
	private String clave;
	
	@Column (name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	
	@Column (name = "ES_FORMULA", nullable = false, length = 1)
	private Boolean esFormula;
	
	@Column (name = "FORMULA", nullable = true, length = 1000)
	private String formula;
	
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
	@JoinColumn(name = "ID_EDO_FIN")
	private EstadoFinanciero edoFinanciero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public EstadoFinanciero getEdoFinanciero() {
		return edoFinanciero;
	}

	public void setEdoFinanciero(EstadoFinanciero edoFinanciero) {
		this.edoFinanciero = edoFinanciero;
	}

	public Boolean getEsFormula() {
		return esFormula;
	}

	public void setEsFormula(Boolean esFormula) {
		this.esFormula = esFormula;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", esFormula=" + esFormula
				+ ", formula=" + formula + "]";
	}

	
	
}
