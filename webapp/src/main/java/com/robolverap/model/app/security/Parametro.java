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
@Table(name = "seg_parametros")
public class Parametro implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2487161368351282248L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", nullable = false)
	private Integer id;
	
	@Column (name = "CLAVE", nullable = false, length = 45)
	private String clave;
	
	@Column (name = "DESCRIPCION", nullable = false, length = 200)
	private String descripcion;
	
	@Column (name = "VALOR", nullable = false, length = 200)
	private String valor;
	
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
		Parametro other = (Parametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parametro [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}

	
	

}
