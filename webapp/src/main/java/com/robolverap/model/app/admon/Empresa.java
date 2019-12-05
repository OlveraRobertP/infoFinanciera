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
@Table(name = "adm_empresa")
public class Empresa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1310565660004007769L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column (name = "NUMERO",  length = 25)
	private String numero;
	
	@Column (name = "NOMBRE", nullable = false, length = 150)
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_EMPRESA")
	private TipoEmpresa tipoEmpresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", tipoEmpresa=" + tipoEmpresa + "]";
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
