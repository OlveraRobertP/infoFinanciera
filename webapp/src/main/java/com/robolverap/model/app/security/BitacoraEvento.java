/**
 * 
 */
package com.robolverap.model.app.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jrobolvp
 *
 */
@Entity
@Table(name = "seg_bitacora_eventos")
public class BitacoraEvento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8041127916475984619L;
	
	@Id
	@Column (name = "ID", nullable = false)
	private Integer id;
	
	@Column (name = "CLAVE", nullable = false, length = 15)
	private String clave;
	
	@Column (name = "DESCRIPCION", nullable = false, length = 100)
	private String descripcion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BitacoraEvento other = (BitacoraEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BitacoraEvento [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + "]";
	}
	
	

}
