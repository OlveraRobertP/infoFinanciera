/**
 * 
 */
package com.robolverap.model.app.financieros;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
@Entity
@Table(name = "fin_edos_financieros")
public class EstadoFinanciero implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 825484873276120600L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column (name = "CLAVE", unique = true, nullable = false, length = 15)
	private String clave;
	
	@Column (name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	
	@Column (name = "DESCRIPCION", nullable = true, length = 200)
	private String descripcion;
	
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
	
	@OneToMany(mappedBy = "edoFinanciero", cascade = CascadeType.ALL, fetch  = FetchType.EAGER)
	@OrderBy("id ASC")
	@Fetch (FetchMode.SELECT) 
    private List<Cuenta> cuentas;

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

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "EstadoFinanciero [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
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
		EstadoFinanciero other = (EstadoFinanciero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
