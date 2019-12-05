package com.robolverap.model.app.admon;

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
@Table(name = "adm_empresa_tipo")
public class TipoEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7241988747644965321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column (name = "CLAVE", unique = true, nullable = false, length = 15)
	private String clave;
	
	@Column (name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	
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
		TipoEmpresa other = (TipoEmpresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEmpresa [id=" + id + ", clave=" + clave + ", nombre=" + nombre + "]";
	}
	
	

}
