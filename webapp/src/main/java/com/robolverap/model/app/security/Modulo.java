package com.robolverap.model.app.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author Roberto Olvera
 *
 */
@Entity
@Table(name = "seg_modulos")
public class Modulo implements Serializable,Comparable<Modulo>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 994900493612558230L;

	@Id
	@Column (name = "CVE_MODULO", unique = true, nullable = false, length = 15)
	private String clave;
	
	public Modulo() {
	}
	
	public Modulo(String clave) {
		super();
		this.clave = clave;
	}

	@Column (name = "NOMBRE", nullable = false, length = 45)
	private String nombre;
	
	@Column (name = "F_ALTA", nullable = false)
	private Date fecReg;
	
	@Column (name = "F_MODIF", nullable = false)
	private Date fecMod;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO_ALTA")
	private Usuario usuReg;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO_MODIF")
	private Usuario usuMod;
	
	@Column (name = "ETIQUETA", nullable = true, length = 45)
	private String etiqueta;
	
	@Column (name = "ICONO", nullable = true, length = 15)
	private String icono;
	
	@Column (name = "ORDEN", nullable = true)
	private Integer orden;
	
	@OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL, fetch  = FetchType.EAGER)
	@OrderBy("orden ASC")
    private Set<Funcion> funciones;

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

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	public Set<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Set<Funcion> funciones) {
		this.funciones = funciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}

	@Override
	public int compareTo(Modulo o) {
		return this.orden.compareTo(o.getOrden());
	}

	@Override
	public String toString() {
		return "Modulo [clave=" + clave + ", nombre=" + nombre + "]";
	}
	
	


}
