/**
 * 
 */
package com.robolverap.model.app.security;

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

/**
 * @author jrobolvp
 *
 */

@Entity
@Table(name = "seg_bitacora")
public class Bitacora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -591199302995715569L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", nullable = false)
	private Integer id;
	
	@Column (name = "DESCRIPCION", nullable = true, length = 1000)
	private String descripcion;
	
	@Column (name = "F_ALTA", nullable = false)
	private Date fecReg;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO_ALTA")
	private Usuario usuReg;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENTO")
	private BitacoraEvento evento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Usuario getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(Usuario usuReg) {
		this.usuReg = usuReg;
	}

	public BitacoraEvento getEvento() {
		return evento;
	}

	public void setEvento(BitacoraEvento evento) {
		this.evento = evento;
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
		Bitacora other = (Bitacora) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bitacora [id=" + id + ", descripcion=" + descripcion + ", evento=" + evento.getClave() + "]";
	}
	
	
	

}
