package com.robolverap.model.app.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Roberto Olvera
 *
 */
@Entity
@Table(name = "seg_funciones")
public class Funcion implements Serializable, Comparable<Funcion>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7355094818623141889L;

	@Id
	@Column (name = "CVE_FUNCION", unique = true, nullable = false, length = 15)
	private String clave;
	
	@Column (name = "NOMBRE", nullable = false, length = 45)
	private String nombre;
	
	@Column (name = "DESCRIPCION", nullable = false, length = 100)
	private String descripcion;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CVE_MODULO")
	private Modulo modulo;
	
	@Column (name = "ETIQUETA", nullable = true, length = 45)
	private String etiqueta;
	
	@Column (name = "ICONO", nullable = true, length = 15)
	private String icono;
	
	@Column (name = "ORDEN", nullable = true)
	private Integer orden;

	@Column (name = "URL", nullable = true)
	private String url;
	
	@ManyToMany(mappedBy = "funciones")
	private Set<Rol> roles = new HashSet<>();

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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
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
		Funcion other = (Funcion) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}

	@Override
	public int compareTo(Funcion o) {
		return this.clave.compareTo(o.clave);
	}

	@Override
	public String toString() {
		return "Funcion [clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	

}
